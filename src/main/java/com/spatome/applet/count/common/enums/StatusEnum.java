package com.spatome.applet.count.common.enums;

public enum StatusEnum {
	ON("开启"), OFF("关闭"), STOP("暂停");

	private String text;

	StatusEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
