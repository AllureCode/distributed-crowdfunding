package com.gnawococ.crowd.controller;

import com.gnawococ.crowd.entity.MemberPO;
import com.gnawococ.crowd.entity.ResultEntity;
import com.gnawococ.crowd.service.MemberService;
import com.gnawococ.crowd.utils.CrowUtils;
import com.gnawococ.crowd.utils.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: distributed-crowdfunding
 * @description: member controller
 * @author: wang_sir
 * @create: 2020-05-29 09:02
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @GetMapping("/retrieve/login/acct/count")
    ResultEntity<Integer> retrieveLoginAcctCount(@RequestParam("loginAcct")String loginAcct){
        Integer count = 0;
        if (!CrowUtils.strEffectiveCheck(loginAcct)){
            return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_INVALID);
        }
        try {
            count =  memberService.getLoginAcct(loginAcct);
            return ResultEntity.successWithData(count);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_INVALID);
        }
    }


    @PostMapping("/save/member/remote")
    ResultEntity<String> saveMemberRemote(@RequestBody MemberPO memberPO){
        try {
           memberService.saveMemerPO(memberPO);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(CrowdConstant.MESSAGE_MEMBER_SAVE_FAILED);
        }
    }
}
