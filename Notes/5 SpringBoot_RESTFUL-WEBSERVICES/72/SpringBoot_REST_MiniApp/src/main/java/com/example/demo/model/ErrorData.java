package com.example.demo.model;

public class ErrorData {
	private String message;
	private String datetime;
	private String module;
	@Override
	public String toString() {
		return "ErrorData [message=" + message + ", datetime=" + datetime + ", module=" + module + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public ErrorData(String message, String datetime, String module) {
		super();
		this.message = message;
		this.datetime = datetime;
		this.module = module;
	}
	public ErrorData() {}

}
