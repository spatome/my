package com.spatome.applet.activity.entity;

import java.util.Date;

public class Draw {
    private Long id;

    private String ownerNo;

    private Long activityId;

    private Long prizeId;

    private Date createDate;

    private Date createTime;

    private String isEnter;

    private String isEnterDescs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo == null ? null : ownerNo.trim();
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsEnter() {
        return isEnter;
    }

    public void setIsEnter(String isEnter) {
        this.isEnter = isEnter == null ? null : isEnter.trim();
    }

    public String getIsEnterDescs() {
        return isEnterDescs;
    }

    public void setIsEnterDescs(String isEnterDescs) {
        this.isEnterDescs = isEnterDescs == null ? null : isEnterDescs.trim();
    }
}