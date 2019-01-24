package com.spatome.applet.entity;

import java.util.Date;

public class ZjRecord {
    private Long id;

    private Long activityZjId;

    private String ownerNo;

    private String actorNo;

    private String isWin;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityZjId() {
        return activityZjId;
    }

    public void setActivityZjId(Long activityZjId) {
        this.activityZjId = activityZjId;
    }

    public String getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo == null ? null : ownerNo.trim();
    }

    public String getActorNo() {
        return actorNo;
    }

    public void setActorNo(String actorNo) {
        this.actorNo = actorNo == null ? null : actorNo.trim();
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin == null ? null : isWin.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}