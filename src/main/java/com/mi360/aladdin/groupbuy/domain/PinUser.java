package com.mi360.aladdin.groupbuy.domain;

import java.io.Serializable;
import java.util.Date;

public class PinUser implements Serializable{
	private static final long serialVersionUID = -6664027626769628792L;

	private Integer ID;

    private Integer pinID;

    private Integer openID;

    private String mqID;

    private Date createTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPinID() {
        return pinID;
    }

    public void setPinID(Integer pinID) {
        this.pinID = pinID;
    }

    public Integer getOpenID() {
        return openID;
    }

    public void setOpenID(Integer openID) {
        this.openID = openID;
    }

    public String getMqID() {
        return mqID;
    }

    public void setMqID(String mqID) {
        this.mqID = mqID == null ? null : mqID.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
	public String toString() {
		return "PinUser [ID=" + ID + ", pinID=" + pinID + ", openID=" + openID
				+ ", mqID=" + mqID + ", createTime=" + createTime + "]";
	}

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}