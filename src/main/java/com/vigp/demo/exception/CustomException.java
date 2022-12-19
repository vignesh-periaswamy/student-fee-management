package com.vigp.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class CustomException  extends HttpStatusCodeException {

	private static final long serialVersionUID = 1L;

	public CustomException(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}
	
}
