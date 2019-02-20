package com.spatome.applet.activity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrizeVO {

	public Long prizeId;
	public String prizeName;
	public String prizePr;
	public String prizeIconName;
	public String prizeIconUrl;
	public String prizeImageName;
	public String prizeImageUrl;
	public String prizeCount;
	public String prizeBalance;
	public String createTime;
	public String isEnter;
	public String status;

}
