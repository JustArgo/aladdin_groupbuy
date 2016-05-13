package com.mi360.aladdin.groupbuy.mapper;

import java.util.List;

import com.mi360.aladdin.groupbuy.domain.PinUser;

public interface PinUserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinUser record);

    int insertSelective(PinUser record);

    PinUser selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinUser record);

    int updateByPrimaryKey(PinUser record);
    
    List<PinUser> selectByCondition(PinUser pinUser);
}