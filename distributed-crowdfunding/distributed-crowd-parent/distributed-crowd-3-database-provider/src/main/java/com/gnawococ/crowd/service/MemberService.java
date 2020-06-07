package com.gnawococ.crowd.service;

import com.gnawococ.crowd.entity.MemberPO;

/**
 * @Author:  wang_sir
 * @Description: member service
 * @Date: 8:58 2020/5/29
 * @Param:
 * @return:
 **/
public interface MemberService {

    /**
     * 根据账号查询对应的账户个数
     * @param loginAcct
     * @return
     */
    Integer getLoginAcct(String loginAcct);

    int saveMemerPO(MemberPO memberPO);
}
