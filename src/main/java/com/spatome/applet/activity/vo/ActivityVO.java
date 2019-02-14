package com.spatome.applet.activity.vo;

import java.util.ArrayList;
import java.util.List;

public class ActivityVO {

	private Long activityId;
	private String activityName;
	private String enterpriseName;
	private String allowDayCount;
	private String createTime;
	private String status;
	private List<PrizeVO> prizeList;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getAllowDayCount() {
		return allowDayCount;
	}

	public void setAllowDayCount(String allowDayCount) {
		this.allowDayCount = allowDayCount;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PrizeVO> getPrizeList() {
		if(prizeList==null){
			prizeList = new ArrayList<PrizeVO>();
		}
		return prizeList;
	}

	public void setPrizeList(List<PrizeVO> prizeList) {
		this.prizeList = prizeList;
	}

}
