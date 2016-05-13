package com.mi360.aladdin.groupbuy.mapper;

import java.util.List;

import com.mi360.aladdin.groupbuy.domain.PinOrder;

public interface PinOrderMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinOrder record);

    int insertSelective(PinOrder record);

    PinOrder selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinOrder record);

    int updateByPrimaryKey(PinOrder record);
    
    List<PinOrder> selectByCondition(PinOrder pinOrder);
    
    List<PinOrder> selectByMqID(String mqID);
    
    List<PinOrder> selectByIDs(Integer[] ids);
}