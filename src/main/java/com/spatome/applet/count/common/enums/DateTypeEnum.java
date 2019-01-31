package com.spatome.applet.count.common.enums;

public enum DateTypeEnum {
	A("全部"), H("小时"), D("天");

	private String text;

	DateTypeEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
