package com.spatome.applet.count.vo;

import java.util.ArrayList;
import java.util.List;

public class ActivityCountVO {

	private Long activityId;
	private String activityName;
	private String descs;

	private String status;
	private String createTime;

	private List<ActivityItemVO> itemList;

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

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<ActivityItemVO> getItemList() {
		if(itemList==null){
			itemList = new ArrayList<ActivityItemVO>();
		}
		return itemList;
	}

	public void setItemList(List<ActivityItemVO> itemList) {
		this.itemList = itemList;
	}

}
