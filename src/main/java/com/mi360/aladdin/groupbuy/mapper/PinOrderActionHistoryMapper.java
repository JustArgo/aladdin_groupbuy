package com.mi360.aladdin.groupbuy.mapper;

import com.mi360.aladdin.groupbuy.domain.PinOrderActionHistory;

public interface PinOrderActionHistoryMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinOrderActionHistory record);

    int insertSelective(PinOrderActionHistory record);

    PinOrderActionHistory selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinOrderActionHistory record);

    int updateByPrimaryKey(PinOrderActionHistory record);
}