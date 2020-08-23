package com.training.bms.exception;

import org.springframework.web.server.ResponseStatusException;

public class ErrorResponse extends RuntimeException {
	
	private String message;
	private Integer status;
	
	public ErrorResponse(String message, Integer status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

	
	

}
