package com.gnawococ.crowd.mapper;

import com.gnawococ.crowd.entity.MemberPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPO record);

    int insertSelective(MemberPO record);

    MemberPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPO record);

    int updateByPrimaryKey(MemberPO record);

    Integer selectByLoginAcct(String loginAcct);

    MemberPO selectMemberByLoginAcct(String loginAcct);
}