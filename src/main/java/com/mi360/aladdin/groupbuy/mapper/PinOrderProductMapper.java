package com.mi360.aladdin.groupbuy.mapper;

import java.util.List;

import com.mi360.aladdin.groupbuy.domain.PinOrderProduct;

public interface PinOrderProductMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinOrderProduct record);

    int insertSelective(PinOrderProduct record);

    PinOrderProduct selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinOrderProduct record);

    int updateByPrimaryKey(PinOrderProduct record);
    
    List<PinOrderProduct> selectByMqID(String mqID);
}