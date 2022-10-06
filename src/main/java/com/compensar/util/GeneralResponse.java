package com.compensar.util;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class GeneralResponse {

	private Date date;

	private HttpStatus status;

	private String Message;

	private String Content;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public GeneralResponse(Date date, HttpStatus status, String message, String content) {
		super();
		this.date = date;
		this.status = status;
		Message = message;
		Content = content;
	}

	@Override
	public String toString() {
		return "GeneralResponse [date=" + date + ", Message=" + Message + ", Content=" + Content + "]";
	}

}
