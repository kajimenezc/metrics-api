package com.compensar.util;

import org.springframework.http.HttpStatus;

public class GeneralResponse {

	private String date;

	private HttpStatus status;

	private String Message;

	private String Content;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public GeneralResponse(String date, String message, String content) {
		super();
		this.date = date;
		Message = message;
		Content = content;
	}

	@Override
	public String toString() {
		return "GeneralResponse [date=" + date + ", Message=" + Message + ", Content=" + Content + "]";
	}

}
