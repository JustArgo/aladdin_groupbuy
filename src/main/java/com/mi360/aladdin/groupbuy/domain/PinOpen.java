package com.mi360.aladdin.groupbuy.domain;

import java.io.Serializable;
import java.util.Date;

public class PinOpen implements Serializable{
	private static final long serialVersionUID = 363026849100445696L;

	private Integer ID;

    private String mqID;

    private Integer productID;

    private Integer pinID;

    private String status;

    private String pinStatus;

    private Integer alreadys;

    private Integer cans;

    private Date createTime;

    private Date endTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMqID() {
        return mqID;
    }

    public void setMqID(String mqID) {
        this.mqID = mqID == null ? null : mqID.trim();
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getPinID() {
        return pinID;
    }

    public void setPinID(Integer pinID) {
        this.pinID = pinID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus) {
        this.pinStatus = pinStatus == null ? null : pinStatus.trim();
    }

    public Integer getAlreadys() {
        return alreadys;
    }

    public void setAlreadys(Integer alreadys) {
        this.alreadys = alreadys;
    }

    public Integer getCans() {
        return cans;
    }

    public void setCans(Integer cans) {
        this.cans = cans;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	@Override
	public String toString() {
		return "PinOpen [ID=" + ID + ", mqID=" + mqID + ", productID="
				+ productID + ", pinID=" + pinID + ", status=" + status
				+ ", pinStatus=" + pinStatus + ", alreadys=" + alreadys
				+ ", cans=" + cans + ", createTime=" + createTime
				+ ", endTime=" + endTime + "]";
	}
}