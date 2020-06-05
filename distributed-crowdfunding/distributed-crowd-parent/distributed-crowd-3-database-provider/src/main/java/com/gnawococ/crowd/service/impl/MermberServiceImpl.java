package com.gnawococ.crowd.service.impl;

import com.gnawococ.crowd.mapper.MemberPOMapper;
import com.gnawococ.crowd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: distributed-crowdfunding
 * @description: member service implement
 * @author: wang_sir
 * @create: 2020-05-29 08:58
 **/
@Service
@Transactional(readOnly = true)
public class MermberServiceImpl implements MemberService {
    @Autowired
    private MemberPOMapper memberPOMapper;
    /**
     * Corresponding  method
     */

}
