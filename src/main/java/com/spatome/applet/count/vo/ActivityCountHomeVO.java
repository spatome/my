package com.spatome.applet.count.vo;

import java.util.ArrayList;
import java.util.List;

public class ActivityCountHomeVO {

	private Long activityId;
	private String activityName;

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
