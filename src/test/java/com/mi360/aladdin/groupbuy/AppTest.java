package com.mi360.aladdin.groupbuy;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mi360.aladdin.groupbuy.domain.PinInfo;
import com.mi360.aladdin.groupbuy.service.IGroupBuyService;

public class AppTest {
	
	
	private IGroupBuyService groupBuyService;
	
	@Before
	public void setUp(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-groupbuy.xml");
		ctx.start();
		groupBuyService = ctx.getBean(IGroupBuyService.class);
		
	}
	
	/**
	 * 新增拼团
	 */
	@Test
	public void testAddPinInfo(){
		PinInfo pinInfo = new PinInfo();
		pinInfo.setBeginTime(new Date());		//开团时间
		pinInfo.setCanCount(25);				//25人团
		pinInfo.setCreateTime(new Date());		//创建时间		可以和开团时间不同
		pinInfo.setEndTime(new Date(pinInfo.getBeginTime().getTime()+15*60*1000));//拼团结束时间
		pinInfo.setLimitCount(1);				//每人限购数量
		pinInfo.setPeople(25);					//总参与人数
		pinInfo.setPinCode(UUID.randomUUID().toString().replace("-", "").substring(2));//拼团自编号
		pinInfo.setPinCount(10);			//拼团人数  和 总参与人数不同
		pinInfo.setPlatform("WX#");			//在什么平台展示
		pinInfo.setPrice(550L);				//商品原价
		pinInfo.setProductID(296);			//商品ID
		pinInfo.setSells(1);			//总已经购买量
		pinInfo.setSortOrder(4);		//排序
		pinInfo.setStatus("DEL");			//拼团状态 上架  删除  草稿
		pinInfo.setSupplyID(1);			//供应商ID
		pinInfo.setUid(2);				//后台用书输入人id 正常情况下为供应商的id
		pinInfo.setUpdateTime(new Date());	//何时更新一个拼团
		
		groupBuyService.addPinInfo(pinInfo, "asfd");
	}
	
	/**
	 * 查找拼团
	 */
	@Test
	public void testGetPinInfo(){
		PinInfo pinInfo = groupBuyService.getPinInfo(1, "");
		System.out.println(pinInfo);
	}
	
	/**
	 * 查找上架拼团
	 */
	@Test
	public void testGetPinInfoList(){
		List<PinInfo> pinInfoList = groupBuyService.getPinInfoList("");
		for(int i=0;i<pinInfoList.size();i++){
			System.out.println(pinInfoList.get(i));
		}
	}
	
	/**
	 * 删除拼团
	 */
	@Test
	public void testDeletePinInfo(){
		
		Integer[] ids = new Integer[]{1,2,3};
		groupBuyService.deletePinInfo(ids, "sdfsf");
		
		
	}
	
	/**
	 * 上架拼团
	 */
	@Test
	public void testPutOnShelves(){
		Integer[] ids = new Integer[]{1,2,3};
		groupBuyService.putOnShelvesPinInfo(ids, "sdfsdf");
	}
	
}
