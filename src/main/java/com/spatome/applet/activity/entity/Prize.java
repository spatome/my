package com.spatome.applet.activity.entity;

import java.util.Date;

public class Prize {
    private Long id;

    private String ownerNo;

    private String prizeName;

    private String prizeIconName;

    private String prizeImageName;

    private Integer prizeCount;

    private Integer prizeBalance;

    private Date createTime;

    private Date updateTime;

    private String isEnter;

    private String status;

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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public String getPrizeIconName() {
        return prizeIconName;
    }

    public void setPrizeIconName(String prizeIconName) {
        this.prizeIconName = prizeIconName == null ? null : prizeIconName.trim();
    }

    public String getPrizeImageName() {
        return prizeImageName;
    }

    public void setPrizeImageName(String prizeImageName) {
        this.prizeImageName = prizeImageName == null ? null : prizeImageName.trim();
    }

    public Integer getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
    }

    public Integer getPrizeBalance() {
        return prizeBalance;
    }

    public void setPrizeBalance(Integer prizeBalance) {
        this.prizeBalance = prizeBalance;
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

    public String getIsEnter() {
        return isEnter;
    }

    public void setIsEnter(String isEnter) {
        this.isEnter = isEnter == null ? null : isEnter.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}