package com.mi360.aladdin.groupbuy.domain;

import java.io.Serializable;
import java.util.Date;

public class PinInfo implements Serializable{
	private static final long serialVersionUID = 5363774941739427752L;

	private Integer ID;

    private Integer supplyID;

    private Integer productID;

    private String pinTitle;

    private String pinCode;

    private Long pinPrice;

    private Long price;

    private String pinImg;

    private Integer canCount;

    private Integer sells;

    private Integer people;

    private Integer pinCount;

    private Integer limitCount;

    private Integer sortOrder;

    private String platform;

    private String status;

    private Integer uid;

    private Date endTime;

    private Date beginTime;

    private Date createTime;

    private Date updateTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSupplyID() {
        return supplyID;
    }

    public void setSupplyID(Integer supplyID) {
        this.supplyID = supplyID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getPinTitle() {
        return pinTitle;
    }

    public void setPinTitle(String pinTitle) {
        this.pinTitle = pinTitle == null ? null : pinTitle.trim();
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode == null ? null : pinCode.trim();
    }

    public Long getPinPrice() {
        return pinPrice;
    }

    public void setPinPrice(Long pinPrice) {
        this.pinPrice = pinPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPinImg() {
        return pinImg;
    }

    public void setPinImg(String pinImg) {
        this.pinImg = pinImg == null ? null : pinImg.trim();
    }

    public Integer getCanCount() {
        return canCount;
    }

    public void setCanCount(Integer canCount) {
        this.canCount = canCount;
    }

    public Integer getSells() {
        return sells;
    }

    public void setSells(Integer sells) {
        this.sells = sells;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getPinCount() {
        return pinCount;
    }

    public void setPinCount(Integer pinCount) {
        this.pinCount = pinCount;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "PinInfo [ID=" + ID + ", supplyID=" + supplyID + ", productID="
				+ productID + ", pinTitle=" + pinTitle + ", pinCode=" + pinCode
				+ ", pinPrice=" + pinPrice + ", price=" + price + ", pinImg="
				+ pinImg + ", canCount=" + canCount + ", sells=" + sells
				+ ", people=" + people + ", pinCount=" + pinCount
				+ ", limitCount=" + limitCount + ", sortOrder=" + sortOrder
				+ ", platform=" + platform + ", status=" + status + ", uid="
				+ uid + ", endTime=" + endTime + ", beginTime=" + beginTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
}