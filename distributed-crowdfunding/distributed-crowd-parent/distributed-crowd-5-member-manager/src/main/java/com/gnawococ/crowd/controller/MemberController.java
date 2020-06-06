package com.gnawococ.crowd.controller;

import com.gnawococ.crowd.api.RedisOperationRemoteService;
import com.gnawococ.crowd.entity.ResultEntity;
import com.gnawococ.crowd.utils.CrowUtils;
import com.gnawococ.crowd.utils.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/member/manager/send/code")
    public ResultEntity<String> sendCode(@RequestParam("phoneNum")String phoneNum) throws Exception {
        if (!CrowUtils.strEffectiveCheck(phoneNum)){
            return ResultEntity.failed(CrowdConstant.MESSAGE_PHONE_NUM_INVALID);
        }
        int length = 4;
        //生成验证码
        String randomCode = CrowUtils.randomCode(length);
        Integer timeoutMinute = 15;
        String normalKey = CrowdConstant.REDIS_RANDOM_CODE_PREFIX+phoneNum;
        //保存验证码到redis
        try {
            redisOperationRemoteService.saveNormalStringKeyValue(normalKey,randomCode,timeoutMinute);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(CrowdConstant.MESSAGE_SAVE_REDIS_FAILED);
        }
        //发送短信
        String appcode = "cb67b38ba0844e79a008b5268678abcd";
        try {
            CrowUtils.sendShortMessage(appcode, randomCode, phoneNum);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
