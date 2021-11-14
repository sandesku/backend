package com.spring.demo.response;

public class FinalResponse {
	private Integer code;
	private String message;
	private Object data;
	
	public FinalResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public FinalResponse(Integer code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
