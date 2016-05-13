package com.mi360.aladdin.groupbuy.domain;

import java.io.Serializable;
import java.util.Date;

public class PinOrderProduct implements Serializable{
	private static final long serialVersionUID = -1133438989308465453L;

	private Integer ID;

    private Integer orderID;

    private Integer productID;

    private String productName;

    private Integer supID;

    private String supName;

    private Integer skuID;

    private String skuNameStr;

    private Long supPrice;

    private Long price;

    private Long sum;

    private Long count;

    private Long postPay;

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

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getSupID() {
        return supID;
    }

    public void setSupID(Integer supID) {
        this.supID = supID;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName == null ? null : supName.trim();
    }

    public Integer getSkuID() {
        return skuID;
    }

    public void setSkuID(Integer skuID) {
        this.skuID = skuID;
    }

    public String getSkuNameStr() {
        return skuNameStr;
    }

    public void setSkuNameStr(String skuNameStr) {
        this.skuNameStr = skuNameStr == null ? null : skuNameStr.trim();
    }

    public Long getSupPrice() {
        return supPrice;
    }

    public void setSupPrice(Long supPrice) {
        this.supPrice = supPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPostPay() {
        return postPay;
    }

    public void setPostPay(Long postPay) {
        this.postPay = postPay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "PinOrderProduct [ID=" + ID + ", orderID=" + orderID
				+ ", productID=" + productID + ", productName=" + productName
				+ ", supID=" + supID + ", supName=" + supName + ", skuID="
				+ skuID + ", skuNameStr=" + skuNameStr + ", supPrice="
				+ supPrice + ", price=" + price + ", sum=" + sum + ", count="
				+ count + ", postPay=" + postPay + ", createTime=" + createTime
				+ "]";
	}
    
}