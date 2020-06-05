package com.gnawococ.crowd.mapper;

import com.gnawococ.crowd.entity.MemberPO;

public interface MemberPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPO record);

    int insertSelective(MemberPO record);

    MemberPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPO record);

    int updateByPrimaryKey(MemberPO record);
}