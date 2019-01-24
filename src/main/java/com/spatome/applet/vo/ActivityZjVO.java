package com.spatome.applet.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityZjVO {

	private Long activityId;
	private String ownerNo;
	private String activityName;
	private String beginTime;	//yyyy-MM-dd
	private String endTime;		//yyyy-MM-dd
	private String descs;
	private String totalCount;
	private String drawCount;
	private String imageUrl;

	private String status;
	private String createTime;	//01-01 00:00
	private String hintNo;
	
	private String curDrawCount;
	private String curDrawedCount;

	private String isDraw;		//已抽？ 
	private String isDrawed;	//抽中？
}
