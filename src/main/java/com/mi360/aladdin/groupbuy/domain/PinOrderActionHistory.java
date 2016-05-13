package com.mi360.aladdin.groupbuy.domain;

import java.io.Serializable;
import java.util.Date;

public class PinOrderActionHistory implements Serializable{
	private static final long serialVersionUID = -5759127382091716365L;

	private Integer ID;

    private Integer orderID;

    private String orderSn;

    private Integer supplyID;

    private String mqID;

    private Integer uid;

    private String operatorType;

    private String orderStatus;

    private String shippingStatus;

    private String payStatus;

    private String returnMoneyStatus;

    private String returnGoodsStatus;

    private String actionType;

    private String actionPos;

    private Long pSum1;

    private Long orderSum1;

    private Long pSum2;

    private Long orderSum2;

    private Long paySum;

    private String actionNote;

    private Date createTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getSupplyID() {
        return supplyID;
    }

    public void setSupplyID(Integer supplyID) {
        this.supplyID = supplyID;
    }

    public String getMqID() {
        return mqID;
    }

    public void setMqID(String mqID) {
        this.mqID = mqID == null ? null : mqID.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus == null ? null : shippingStatus.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getReturnMoneyStatus() {
        return returnMoneyStatus;
    }

    public void setReturnMoneyStatus(String returnMoneyStatus) {
        this.returnMoneyStatus = returnMoneyStatus == null ? null : returnMoneyStatus.trim();
    }

    public String getReturnGoodsStatus() {
        return returnGoodsStatus;
    }

    public void setReturnGoodsStatus(String returnGoodsStatus) {
        this.returnGoodsStatus = returnGoodsStatus == null ? null : returnGoodsStatus.trim();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    public String getActionPos() {
        return actionPos;
    }

    public void setActionPos(String actionPos) {
        this.actionPos = actionPos == null ? null : actionPos.trim();
    }

    public Long getpSum1() {
        return pSum1;
    }

    public void setpSum1(Long pSum1) {
        this.pSum1 = pSum1;
    }

    public Long getOrderSum1() {
        return orderSum1;
    }

    public void setOrderSum1(Long orderSum1) {
        this.orderSum1 = orderSum1;
    }

    public Long getpSum2() {
        return pSum2;
    }

    public void setpSum2(Long pSum2) {
        this.pSum2 = pSum2;
    }

    public Long getOrderSum2() {
        return orderSum2;
    }

    public void setOrderSum2(Long orderSum2) {
        this.orderSum2 = orderSum2;
    }

    public Long getPaySum() {
        return paySum;
    }

    public void setPaySum(Long paySum) {
        this.paySum = paySum;
    }

    public String getActionNote() {
        return actionNote;
    }

    public void setActionNote(String actionNote) {
        this.actionNote = actionNote == null ? null : actionNote.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "PinOrderActionHistory [ID=" + ID + ", orderID=" + orderID
				+ ", orderSn=" + orderSn + ", supplyID=" + supplyID + ", mqID="
				+ mqID + ", uid=" + uid + ", operatorType=" + operatorType
				+ ", orderStatus=" + orderStatus + ", shippingStatus="
				+ shippingStatus + ", payStatus=" + payStatus
				+ ", returnMoneyStatus=" + returnMoneyStatus
				+ ", returnGoodsStatus=" + returnGoodsStatus + ", actionType="
				+ actionType + ", actionPos=" + actionPos + ", pSum1=" + pSum1
				+ ", orderSum1=" + orderSum1 + ", pSum2=" + pSum2
				+ ", orderSum2=" + orderSum2 + ", paySum=" + paySum
				+ ", actionNote=" + actionNote + ", createTime=" + createTime
				+ "]";
	}
}