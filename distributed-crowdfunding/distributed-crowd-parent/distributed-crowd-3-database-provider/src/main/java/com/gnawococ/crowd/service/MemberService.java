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

    /**
     * 保存对应的member信息
     * @param memberPO
     * @return
     */
    int saveMemerPO(MemberPO memberPO);

    /**
     * 根据账户查询member
     * @param loginAcct
     * @return
     */
    MemberPO getMemberByLoginAcct(String loginAcct);
}
