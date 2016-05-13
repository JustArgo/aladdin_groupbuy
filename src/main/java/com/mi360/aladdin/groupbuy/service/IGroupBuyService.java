package com.mi360.aladdin.groupbuy.service;

import java.util.List;
import java.util.Map;

import com.mi360.aladdin.groupbuy.domain.PinInfo;
import com.mi360.aladdin.groupbuy.domain.PinOpen;
import com.mi360.aladdin.groupbuy.domain.PinOrder;
import com.mi360.aladdin.groupbuy.domain.PinOrderProduct;

public interface IGroupBuyService {

	/**
	 * 新增一个拼团
	 */
	int addPinInfo(PinInfo pinInfo,String requestID);
	
	/**
	 * 查看单个拼团
	 */
	PinInfo getPinInfo(Integer pinInfoID,String requestID);
	
	/**
	 * 根据多个id查看拼团列表
	 */
	List<PinInfo> getPinInfoList(Integer[] pinInfoIDs,String requestID);
	
	/**
	 * 查看当前正在进行的拼团
	 */
	List<PinInfo> getPinInfoList(String requestID);
	
	/**
	 * 根据状态查询
	 */
	List<PinInfo> getPinInfoListByStatus(String status, String requestID);
	
	/**
	 * 更新某个拼团
	 */
	int updatePinInfo(PinInfo pinInfo,String requestID);
	
	/**
	 * 删除拼团
	 */
	int deletePinInfo(Integer[] pinInfoIDs,String requestID);
	
	/**
	 * 上架多个拼团
	 */
	int putOnShelvesPinInfo(Integer[] pinInfoIDs,String requestID);
	
	/**
	 * 开团
	 */
	int createGroupBuy(String mqID, Integer pinID, Integer productID, String requestID);
	
	/**
	 * 参团
	 */
	int joinGroupBuy(String mqID, Integer pinID, Integer productID, String requestID);
	
	/**
	 * 提交拼团订单
	 */
	int placeOrder(String mqID, Integer pinUserID, Integer pinID, Integer productID, Integer skuID, Integer buyNum, Long pinPrice, Long postFee, String invoiceName, String notes, String requestID);
	
	/**
	 * 为某个订单设置收货地址
	 */
	PinOrder setReceAdd(String mqID, PinOrder pinOrder, String requestID);
	
	/**
	 * 查看拼团订单
	 */
	List<PinOrder> getPinOrderListByMqID(String mqID, String requestID);
	
	/**
	 * 查看拼团商品
	 */
	List<PinOrderProduct> getPinOrderProductListByMqID(String mqID, String requestID);
	
	/**
	 * 根据多个id 查找PinOrder
	 */
	List<PinOrder> getPinOrderListByIDs(Integer[] pinOrderIDs, String requestID);
	
	/**
	 * 根据拼团id 查找 pinOpen
	 */
	PinOpen getPinOpenByPinInfoID(Integer pinInfoID, String requestID);
	
	/**
	 * 根据拼团id 查找已参团用户信息  list的第一个为团长
	 */
	List<Map<String,Object>> getPinUserList(Integer pinInfoID, String requestID);
	
	/**
	 * 
	 * @param queryCondition  where条件 map包含 3个key  column operator value
	 * @param page		分页条件	
	 * @param pageSize  分页条件
	 * @param orderCondition 排序条件 
	 * @param requestID
	 * @return
	 */
	List<PinInfo> selectByConditionWithPagination(List<Map<String,Object>> queryCondition, Integer page, Integer pageSize, List<Map<String,String>> orderCondition, String requestID);
}
