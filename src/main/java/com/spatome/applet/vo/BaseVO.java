package com.spatome.applet.vo;

import java.io.Serializable;

public class BaseVO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String JSON_RESULT_SUCCESS = "{\"code\":\"0000\",\"message\":\"操作成功\",\"body\":null}";
	public final static String JSON_RESULT_FAIL = "{\"code\":\"9999\",\"message\":\"操作失败\",\"body\":null}";

	private String code;

	private String message;

	private T body;

	public BaseVO() {
		this.code = "0000";
		this.message = "操作成功";
	}

	public BaseVO(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCodeMessage(String code, String message) {
		this.code = code;
		this.message = message;
	};

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}