package com.mi360.aladdin.groupbuy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi360.aladdin.groupbuy.domain.PinInfo;

public interface PinInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PinInfo record);

    int insertSelective(PinInfo record);

    PinInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PinInfo record);

    int updateByPrimaryKey(PinInfo record);
    
    List<PinInfo> selectByCondition(PinInfo pinInfo);
    
    int deletePinInfoByIDs(Integer[] pinInfoIDs);
    
    /**
     * 将拼团上架
     * @param pinInfoIDs
     * @return
     */
    int putOnShelves(Integer[] pinInfoIDs);
    
    /**
     * 选择正在进行的拼团
     * @return
     */
    List<PinInfo> selectPinInfoIng();
    
    /**
     * 根据多个id查找 拼团
     * @param pinInfoIDs
     * @return
     */
    List<PinInfo> selectByIDs(Integer[] pinInfoIDs);

    /**
     * 条件查询
     * @param where
     * @param order
     * @param skip
     * @param pageSize
     * @return
     */
	List<PinInfo> selectByConditionWithPagination(@Param("where")List<Map<String,Object>> where, @Param("order")List<Map<String,String>> order,
			@Param("skip")int skip, @Param("pageSize")int pageSize);
}