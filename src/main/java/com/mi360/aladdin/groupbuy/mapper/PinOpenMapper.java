package com.mi360.aladdin.groupbuy.mapper;

import com.mi360.aladdin.groupbuy.domain.PinOpen;

public interface PinOpenMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinOpen record);

    int insertSelective(PinOpen record);

    PinOpen selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinOpen record);

    int updateByPrimaryKey(PinOpen record);
    
    PinOpen selectByPinInfoID(Integer pinInfoID);
}