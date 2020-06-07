package com.gnawococ.crowd.api;

import com.gnawococ.crowd.entity.MemberPO;
import com.gnawococ.crowd.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wang_sir
 */
@FeignClient("databases-provide")
public interface DataBaseOperationRemoteService {

    /**
     * 远程查询账号个数
     * @param loginAcct
     * @return
     */
    @GetMapping("/retrieve/login/acct/count")
    ResultEntity<Integer> retrieveLoginAcctCount(@RequestParam("loginAcct")String loginAcct);

    /**
     * 远程保存member
     * @param memberPO
     * @return
     */
    @PostMapping("/save/member/remote")
    ResultEntity<String> saveMemberRemote(@RequestBody MemberPO memberPO);
}
