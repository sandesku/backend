package com.spring.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.spring.demo.response.FinalResponse;
import com.spring.demo.util.FinalResponseUtil;

@ControllerAdvice
public class ExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ExceptionHandler(value = { DemoException.class })
	public ResponseEntity<FinalResponse> handleException(DemoException e, WebRequest request) {
		logger.error("DemoException: ", e);
		return FinalResponseUtil.getFinalResponse(e);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<FinalResponse> handleException(Exception e, WebRequest request) {
		logger.error("Exception: ", e);
		return FinalResponseUtil.getFinalResponse(e);
	}
	
}
