package com.mi360.aladdin.groupbuy.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mi360.aladdin.groupbuy.domain.PinInfo;
import com.mi360.aladdin.groupbuy.domain.PinOpen;
import com.mi360.aladdin.groupbuy.domain.PinOrder;
import com.mi360.aladdin.groupbuy.domain.PinOrderProduct;
import com.mi360.aladdin.groupbuy.domain.PinUser;
import com.mi360.aladdin.groupbuy.mapper.PinInfoMapper;
import com.mi360.aladdin.groupbuy.mapper.PinOpenMapper;
import com.mi360.aladdin.groupbuy.mapper.PinOrderMapper;
import com.mi360.aladdin.groupbuy.mapper.PinOrderProductMapper;
import com.mi360.aladdin.groupbuy.mapper.PinUserMapper;
import com.mi360.aladdin.groupbuy.service.IGroupBuyService;
import com.mi360.aladdin.groupbuy.util.LogUtil;
import com.mi360.aladdin.product.domain.Product;
import com.mi360.aladdin.product.domain.ProductSku;
import com.mi360.aladdin.product.service.IProductService;
import com.mi360.aladdin.product.service.IProductSkuService;
import com.mi360.aladdin.receadd.domain.Address;
import com.mi360.aladdin.receadd.domain.ReceiveAddress;
import com.mi360.aladdin.receadd.service.IAddressService;
import com.mi360.aladdin.receadd.service.IManageReceAddService;
import com.mi360.aladdin.supplier.domain.Supplier;
import com.mi360.aladdin.supplier.service.ISupplierService;

public class GroupBuyServiceImpl implements IGroupBuyService{

	private Logger logger = Logger.getLogger(this.getClass());
	
	public static final String serviceName = "拼团微服务";
	
	@Autowired
	private PinInfoMapper pinInfoMapper;
	
	@Autowired 
	private PinOpenMapper pinOpenMapper;
	
	@Autowired
	private PinOrderMapper pinOrderMapper;
	
	@Autowired
	private PinUserMapper pinUserMapper;
	
	@Autowired
	private PinOrderProductMapper pinOrderProductMapper;
	
	@Autowired
	private IManageReceAddService manageReceAddService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductSkuService productSkuService;
	
	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private IAddressService addressService;
	
	//@Autowired
	//private UserService userService;
	
	@Override
	public int addPinInfo(PinInfo pinInfo,String requestID){
		
		LogUtil.logInput(serviceName, "addPinInfo", requestID, pinInfo);
		
		pinInfoMapper.insert(pinInfo);
		
		LogUtil.logOutput(serviceName, "addPinInfo", requestID, pinInfo.getID());
		
		return pinInfo.getID();
	}
	
	@Override
	public PinInfo getPinInfo(Integer pinInfoID, String requestID) {
		
		LogUtil.logInput(serviceName, "getPinInfo", requestID, pinInfoID);
		
		PinInfo pinInfo = pinInfoMapper.selectByPrimaryKey(pinInfoID);
		
		LogUtil.logOutput(serviceName, "getPinInfo", requestID, pinInfo);
		
		return pinInfo;
	}

	@Override
	public List<PinInfo> getPinInfoList(Integer[] pinInfoIDs, String requestID) {
		
		LogUtil.logInput(serviceName, "getPinInfoList", requestID, Arrays.toString(pinInfoIDs));
		
		List<PinInfo> pinInfoList = pinInfoMapper.selectByIDs(pinInfoIDs);
		
		LogUtil.logOutput(serviceName, "getPinInfoList", requestID, pinInfoList);
		
		return pinInfoList;
		
	}

	@Override
	public List<PinInfo> getPinInfoList(String requestID) {
		
		LogUtil.logInput(serviceName, "getPinInfoList", requestID);
		
		List<PinInfo> pinInfoList = pinInfoMapper.selectPinInfoIng();

		LogUtil.logOutput(serviceName, "getPinInfoList", requestID, pinInfoList);
		
		return pinInfoList;
	}

	@Override
	public List<PinInfo> getPinInfoListByStatus(String status, String requestID) {
		
		LogUtil.logInput(serviceName, "getPinInfoListByStatus", requestID, status);
		
		PinInfo pinInfo = new PinInfo();
		pinInfo.setStatus(status);
		List<PinInfo> pinInfoList = pinInfoMapper.selectByCondition(pinInfo);
		
		LogUtil.logOutput(serviceName, "getPinInfoListByStatus", requestID, pinInfoList);
		
		return pinInfoList;
	}

	@Override
	public int updatePinInfo(PinInfo pinInfo, String requestID) {
		
		LogUtil.logInput(serviceName, "updatePinInfo", requestID, pinInfo);
		
		pinInfoMapper.updateByPrimaryKeySelective(pinInfo);
		
		LogUtil.logOutput(serviceName, "updatePinInfo", requestID, pinInfo.getID());
		
		return pinInfo.getID();
	}

	@Override
	public int deletePinInfo(Integer[] pinInfoIDs, String requestID) {
		
		LogUtil.logInput(serviceName, "deletePinInfo", requestID, Arrays.toString(pinInfoIDs));
		
		pinInfoMapper.deletePinInfoByIDs(pinInfoIDs);
		
		LogUtil.logOutput(serviceName, "deletePinInfo", requestID);
		
		return 0;
	}

	@Override
	public int putOnShelvesPinInfo(Integer[] pinInfoIDs, String requestID) {
		
		LogUtil.logInput(serviceName, "putOnShelvesPinInfo", requestID, Arrays.toString(pinInfoIDs));
		
		pinInfoMapper.putOnShelves(pinInfoIDs);
		
		LogUtil.logOutput(serviceName, "putOnShelvesPinInfo", requestID);
		
		return 0;
	}

	@Override
	public int createGroupBuy(String mqID, Integer pinID, Integer productID, String requestID) {
		
		LogUtil.logInput(serviceName, "createGroupBuy", requestID, mqID, pinID, productID);
		
		PinOpen pinOpen = new PinOpen();
		pinOpen.setMqID(mqID);
		pinOpen.setProductID(productID);
		pinOpen.setPinID(pinID);
		pinOpen.setAlreadys(1);
		pinOpen.setCreateTime(new Date());
		pinOpen.setPinStatus("SUC");
		pinOpen.setStatus("ING");
		
		PinInfo pinInfo = pinInfoMapper.selectByPrimaryKey(pinID);
		pinInfo.setPeople(1);
		pinInfo.setUpdateTime(new Date());
		pinInfoMapper.updateByPrimaryKeySelective(pinInfo);
		
		pinOpen.setCans(pinInfo.getPinCount());
		
		pinOpenMapper.insertSelective(pinOpen);
		
		PinUser pinUser = new PinUser();
		pinUser.setCreateTime(pinOpen.getCreateTime());
		pinUser.setMqID(mqID);
		pinUser.setOpenID(pinOpen.getID());
		pinUser.setPinID(pinID);
		
		pinUserMapper.insert(pinUser);
		
		LogUtil.logOutput(serviceName, "createGroupBuy", requestID, pinOpen.getID());
		
		return pinOpen.getID();
	}
	
	@Override
	public int joinGroupBuy(String mqID, Integer pinID, Integer productID,
			String requestID) {
		
		LogUtil.logInput(serviceName, "joinGroupBuy", requestID, mqID, pinID);
		
		PinOpen pinOpen = pinOpenMapper.selectByPinInfoID(pinID);
		PinUser pinUser = new PinUser();
		pinUser.setMqID(mqID);
		pinUser.setOpenID(pinOpen.getID());
		pinUser.setPinID(pinID);
		List<PinUser> pinUserList = pinUserMapper.selectByCondition(pinUser);
		
		if(pinUserList.size()>0){
			throw new RuntimeException("该用户已参加过该拼团");
		}else{
			PinInfo pinInfo = pinInfoMapper.selectByPrimaryKey(pinID);
			pinInfo.setPeople(pinInfo.getPeople()+1);
			pinInfo.setUpdateTime(new Date());
			pinInfoMapper.updateByPrimaryKeySelective(pinInfo);
			
			pinUser.setCreateTime(new Date());
			pinUserMapper.insert(pinUser);
		}
		
		LogUtil.logOutput(serviceName, "joinGroupBuy", requestID, pinUser.getID());
		
		return pinUser.getID();
	}

	@Override
	public int placeOrder(String mqID, Integer pinUserID, Integer pinID, Integer productID, Integer skuID, Integer buyNum,
			Long pinPrice, Long postFee, String invoiceName, String notes, String requestID) {
		
		LogUtil.logInput(serviceName, "placeOrder", requestID, mqID, pinUserID, pinID, productID, skuID, buyNum, pinPrice, postFee, invoiceName, notes);
		
		PinOrder pinOrder = new PinOrder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmddSSS");
		
		pinOrder.setParentID(0);
		pinOrder.setOrderCode(sdf.format(new Date())+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10));
		pinOrder.setOrderStatus("COM");			//订单状态
		pinOrder.setPayStatus("NOT");			//支付状态
		pinOrder.setReturnMoneyStatus("NOT");	//退款状态
		pinOrder.setReturnGoodsStatus("NOT");	//退货状态
		pinOrder.setCommentStatus("NOT");		//评论状态
		pinOrder.setShippingStatus("NOT");		//物流状态
		pinOrder.setPlatform("WX#");
		pinOrder.setMqID(mqID);					//下单用户ID
		pinOrder.setInvoiceName(invoiceName);	//发票抬头
		
		//设置收货地址
		pinOrder = this.setReceAdd(mqID, pinOrder, requestID);
		pinOrder.setCreateTime(new Date());
		pinOrder.setpFee(postFee);
		pinOrder.setpSum(pinPrice*buyNum);
		pinOrder.setNotes(notes);
		pinOrder.setPinID(pinID);
		pinOrder.setPinUserID(pinUserID);

		pinOrderMapper.insertSelective(pinOrder);
		
		Product product = productService.queryProduct(productID, UUID.randomUUID().toString());
		ProductSku productSku = productSkuService.getSkuByID(skuID, UUID.randomUUID().toString());
		Supplier supplier = supplierService.getSupplier(product.getSupplyID(), UUID.randomUUID().toString());
		
		PinOrderProduct pinOrderProduct = new PinOrderProduct();
		pinOrderProduct.setCount(buyNum.longValue());
		pinOrderProduct.setCreateTime(new Date());
		pinOrderProduct.setOrderID(pinOrder.getID());
		pinOrderProduct.setProductID(productID);
		pinOrderProduct.setPostPay(postFee);
		pinOrderProduct.setPrice(pinPrice);
		pinOrderProduct.setProductName(product.getProductName());
		pinOrderProduct.setSkuID(skuID);
		pinOrderProduct.setSkuNameStr(productSku.getName());
		pinOrderProduct.setSum(pinPrice*buyNum);
		pinOrderProduct.setSupID(supplier.getID());
		pinOrderProduct.setSupName(supplier.getName());
		pinOrderProduct.setSupPrice(productSku.getApplyPrice());
		
		pinOrderProductMapper.insertSelective(pinOrderProduct);
		
		LogUtil.logOutput(serviceName, "placeOrder", requestID, pinOrder.getID());
		
		return pinOrder.getID();
	}

	@Override
	public PinOrder setReceAdd(String mqID, PinOrder pinOrder, String requestID) {
		
		if(pinOrder==null){
			return null;
		}
		
		//设置收货地址
		ReceiveAddress receiveAddress = manageReceAddService.getDefaultAddress(mqID, requestID);
		if(receiveAddress!=null){
			pinOrder.setRecName(receiveAddress.getRecName());
			pinOrder.setRecMobile(receiveAddress.getRecMobile());
			pinOrder.setAddress(receiveAddress.getAddress());
			
			Address country  = null;
			Address province = null;
			Address city 	 = null;
			Address district = null;
			
			if(receiveAddress.getCountryID()!=null){
				country = addressService.getAddress(receiveAddress.getCountryID(),UUID.randomUUID().toString());
			}
			if(receiveAddress.getProvinceID()!=null){
				province = addressService.getAddress(receiveAddress.getProvinceID(),UUID.randomUUID().toString());
			}
			if(receiveAddress.getCityID()!=null){
				city = addressService.getAddress(receiveAddress.getCityID(),UUID.randomUUID().toString());
			}
			if(receiveAddress.getDistrictID()!=null){
				district = addressService.getAddress(receiveAddress.getDistrictID(),UUID.randomUUID().toString());
			}
			
			if(country!=null){
				pinOrder.setCountry(country.getName());
			}
			if(province!=null){
				pinOrder.setProvince(province.getName());
			}
			if(city!=null){
				pinOrder.setCity(city.getName());
			}
			if(district!=null){
				pinOrder.setDistrict(district.getName());
			}
		}else{
			pinOrder.setCountry(null);
			pinOrder.setProvince(null);
			pinOrder.setCity(null);
			pinOrder.setDistrict(null);
		}
		
		return pinOrder;
	}

	@Override
	public List<PinOrder> getPinOrderListByMqID(String mqID, String requestID){

		LogUtil.logInput(serviceName, "getPinOrderListByMqID", requestID, mqID);
		
		List<PinOrder> pinOrderList = pinOrderMapper.selectByMqID(mqID);
		
		LogUtil.logOutput(serviceName, "getPinOrderListByMqID", requestID, pinOrderList);
		
		return pinOrderList;
		
	}
	
	@Override
	public List<PinOrderProduct> getPinOrderProductListByMqID(String mqID, String requestID) {
		
		LogUtil.logInput(serviceName, "getPinOrderProductListByMqID", requestID, mqID);

		List<PinOrderProduct> pinOrderProductList = pinOrderProductMapper.selectByMqID(mqID);
		
		LogUtil.logOutput(serviceName, "getPinOrderProductListByMqID", requestID, pinOrderProductList);
		
		return pinOrderProductList;
	}

	@Override
	public List<PinOrder> getPinOrderListByIDs(Integer[] pinOrderIDs,
			String requestID) {
		
		LogUtil.logInput(serviceName, "getPinOrderListByIDs", requestID, Arrays.toString(pinOrderIDs));
		
		List<PinOrder> pinOrderList = pinOrderMapper.selectByIDs(pinOrderIDs);
		
		LogUtil.logOutput(serviceName, "getPinOrderListByIDs", requestID, pinOrderList);
		
		return pinOrderList;
	}

	@Override
	public PinOpen getPinOpenByPinInfoID(Integer pinInfoID, String requestID) {
		
		LogUtil.logInput(serviceName, "getPinOpenByPinInfoID", requestID, pinInfoID);
		
		PinOpen pinOpen = pinOpenMapper.selectByPinInfoID(pinInfoID);
		
		LogUtil.logOutput(serviceName, "getPinOpenByPinInfoID", requestID, pinOpen);
		
		return pinOpen;
	}

	@Override
	public List<Map<String, Object>> getPinUserList(Integer pinInfoID,
			String requestID) {
		
		LogUtil.logInput(serviceName, "getPinUserList", requestID, pinInfoID);
		
		List<Map<String,Object>> pinUserInfoList = new ArrayList<Map<String,Object>>();
		
		PinOpen pinOpen = pinOpenMapper.selectByPinInfoID(pinInfoID);
		PinUser pinUser = new PinUser();
		pinUser.setPinID(pinInfoID);
		pinUser.setOpenID(pinOpen.getID());
		
		List<PinUser> pinUserList = pinUserMapper.selectByCondition(pinUser);
		
		Map<String,Object> colonelInfo = new HashMap<String,Object>();
		Map<String,Object> colonelUser = new HashMap<String,Object>();//userService.findByMqID(pinOpen.getMqID());
		colonelUser.put("nickName", "howald");
		colonelUser.put("headImage", "http://127.0.0.1:9091/images/head_portrait01.png");
		
		colonelInfo.put("nickName", colonelUser.get("nickName"));
		colonelInfo.put("headImage", colonelUser.get("headImage"));
		colonelInfo.put("joinTime", pinOpen.getCreateTime());
		
		pinUserInfoList.add(colonelInfo);
		
		for(int i=0;i<pinUserList.size();i++){
			if(!pinUserList.get(i).getMqID().equals(pinOpen.getMqID())){
				Map<String,Object> memberInfo = new HashMap<String,Object>();
				Map<String,Object> memberUser = new HashMap<String,Object>();//userService.findByMqID(pinUserList.get(i).getMqID());
				memberUser.put("nickName", "member"+i);
				memberUser.put("headImage", "http://127.0.0.1:9091/images/head_portrait02.png");
				
				memberInfo.put("nickName", memberUser.get("nickName"));
				memberInfo.put("headImage", memberUser.get("headImage"));
				memberInfo.put("joinTime", pinUserList.get(i).getCreateTime());
				pinUserInfoList.add(memberInfo);
			}
		}
		
		LogUtil.logOutput(serviceName, "getPinUserList", requestID, pinUserInfoList);
		
		return pinUserInfoList;
	}

	@Override
	public List<PinInfo> selectByConditionWithPagination(
			List<Map<String, Object>> queryCondition, Integer page,
			Integer pageSize, List<Map<String, String>> orderCondition,
			String requestID) {
		
		logger.info("selectByConditionWithPagination");
		
		LogUtil.logInput(serviceName,"selectByConditionWithPagination",requestID,queryCondition,page,pageSize,orderCondition);
		
		List<PinInfo> pinInfoList = pinInfoMapper.selectByConditionWithPagination(queryCondition,orderCondition,(page-1)*pageSize,pageSize);
		
		LogUtil.logOutput(serviceName, "selectByConditionWithPagination", requestID, pinInfoList);

		return pinInfoList;
		
	}

	
	
}
