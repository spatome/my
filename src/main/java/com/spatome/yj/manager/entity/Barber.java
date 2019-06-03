package com.spatome.yj.manager.entity;

import java.util.Date;

public class Barber {
    private Long id;

    private Long storeId;

    private String barberNo;

    private String barberName;

    private String barberLevel;

    private String iconUrl;

    private Integer scores;

    private String workStatus;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String descs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBarberNo() {
        return barberNo;
    }

    public void setBarberNo(String barberNo) {
        this.barberNo = barberNo == null ? null : barberNo.trim();
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName == null ? null : barberName.trim();
    }

    public String getBarberLevel() {
        return barberLevel;
    }

    public void setBarberLevel(String barberLevel) {
        this.barberLevel = barberLevel == null ? null : barberLevel.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus == null ? null : workStatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }
}