package com.spatome.applet.count.common.enums;

public enum ReportTypeEnum {
	B("饼图"), Z("柱图"), X("线图");

	private String text;

	ReportTypeEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
