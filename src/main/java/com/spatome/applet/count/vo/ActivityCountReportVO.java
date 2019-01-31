package com.spatome.applet.count.vo;

import java.util.ArrayList;
import java.util.List;

public class ActivityCountReportVO {

	private Long activityId;
	private String activityName;

	private String reportType;
	private String dateType;

	private List<SplitItem> splitList;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public List<SplitItem> getSplitList() {
		if (splitList == null) {
			splitList = new ArrayList<SplitItem>();
		}
		return splitList;
	}

	public void setSplitList(List<SplitItem> splitList) {
		this.splitList = splitList;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public static class SplitItem {
		private String date;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		private List<ActivityItemVO> itemList;

		public List<ActivityItemVO> getItemList() {
			if (itemList == null) {
				itemList = new ArrayList<ActivityItemVO>();
			}
			return itemList;
		}

		public void setItemList(List<ActivityItemVO> itemList) {
			this.itemList = itemList;
		}
	}
}
