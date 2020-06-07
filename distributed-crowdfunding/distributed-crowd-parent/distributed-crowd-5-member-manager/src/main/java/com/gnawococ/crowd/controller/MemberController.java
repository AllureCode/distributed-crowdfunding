package com.gnawococ.crowd.controller;

import com.gnawococ.crowd.api.DataBaseOperationRemoteService;
import com.gnawococ.crowd.api.RedisOperationRemoteService;
import com.gnawococ.crowd.entity.MemberPO;
import com.gnawococ.crowd.entity.MemberVO;
import com.gnawococ.crowd.entity.ResultEntity;
import com.gnawococ.crowd.utils.CrowdConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.gnawococ.crowd.utils.CrowUtils.*;

/**
 * @program: distributed-crowdfunding
 * @description:
 * @author: wang_sir
 * @create: 2020-06-06 16:01
 **/
@RestController
public class MemberController {
    @Autowired
    private RedisOperationRemoteService redisOperationRemoteService;
    @Value("${crowd.message.appcode}")
    private String appcode;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DataBaseOperationRemoteService dataBaseOperationRemoteService;
    /**
     * 发送短信
     *
     * @param phoneNum
     * @return
     * @throws Exception
     */
    @PostMapping("/member/manager/send/code")
    public ResultEntity<String> sendCode(@RequestParam("phoneNum") String phoneNum) throws Exception {
        if (!strEffectiveCheck(phoneNum)) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_PHONE_NUM_INVALID);
        }
        int length = 4;
        //生成验证码
        String randomCode = randomCode(length);
        Integer timeoutMinute = 15;
        String normalKey = CrowdConstant.REDIS_RANDOM_CODE_PREFIX + phoneNum;
        //保存验证码到redis
        try {
            redisOperationRemoteService.saveNormalStringKeyValue(normalKey, randomCode, timeoutMinute);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(CrowdConstant.MESSAGE_SAVE_REDIS_FAILED);
        }
        //发送短信
        //String appcode = "cb67b38ba0844e79a008b5268678abcd";
        try {
            sendShortMessage(appcode, randomCode, phoneNum);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }


    /**
     * 注册
     * @param memberVO
     * @return
     */
    public ResultEntity<String> register(@RequestBody MemberVO memberVO) {
        //检查验证码是否有效
        String randomCode = memberVO.getRandomCode();
        if (!strEffectiveCheck(randomCode)){
            return ResultEntity.failed(CrowdConstant.MESSAGE_CODE_INVALID);
        }
        //检查手机号是否有效
        String phoneNum = memberVO.getPhoneNum();
        if (!strEffectiveCheck(phoneNum)){
            return ResultEntity.failed(CrowdConstant.MESSAGE_PHONE_NUM_INVALID);
        }
        //拼接随机生成的验证码
        String randomCodeKey = CrowdConstant.REDIS_RANDOM_CODE_PREFIX+phoneNum;
        //调用远程redis-provide查询redis中的验证码
        ResultEntity<String> resultEntityRandomCodeKey = redisOperationRemoteService.retrieveStringValueByStringKey(randomCodeKey);
        if (ResultEntity.FAILED.equals(resultEntityRandomCodeKey.getResult())){
            return resultEntityRandomCodeKey;
        }
        String randomRedis = resultEntityRandomCodeKey.getData();
        if ( randomRedis == null){
            return ResultEntity.failed(CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
        }
        if (!Objects.equals(randomCode, randomRedis)){
            return ResultEntity.failed(CrowdConstant.MESSAGE_CODE_NOT_MATCH);
        }
        //从redis中删除验证码
        ResultEntity<String> resultEntity = redisOperationRemoteService.removeByKey(randomCodeKey);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            return resultEntity;
        }
        //调用远程database-provide检查账号是否被占用
        String loginacct = memberVO.getLoginacct();
        ResultEntity<Integer> loginResultEntity = dataBaseOperationRemoteService.retrieveLoginAcctCount(loginacct);
        if (ResultEntity.FAILED.equals(loginResultEntity.getResult())){
            return ResultEntity.failed(loginResultEntity.getMessage());
        }
        Integer data = loginResultEntity.getData();
        if (data>0){
            return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_OCCUPY);
        }
        //密码加密
        String userpswd = memberVO.getUserpswd();
        String encryptionPassword = bCryptPasswordEncoder.encode(userpswd);
        memberVO.setUserpswd(encryptionPassword);
        //调用远程database-provide保存
        //调用工具类完成属性注入
        MemberPO memberPO = new MemberPO();
        BeanUtils.copyProperties(memberVO, memberPO);
        return dataBaseOperationRemoteService.saveMemberRemote(memberPO);
    }
}
