package com.spring.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.demo.constants.DemoErrorConstant;
import com.spring.demo.exception.DemoException;
import com.spring.demo.response.FinalResponse;

public class FinalResponseUtil {
	
	public static ResponseEntity<FinalResponse> getFinalResponse(DemoException e) {
		return new ResponseEntity<FinalResponse>(new FinalResponse(((DemoException)e).getCode(),e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<FinalResponse> getFinalResponse(Exception e) {
		return new ResponseEntity<FinalResponse>(new FinalResponse(DemoErrorConstant.INTERNAL_SERVER_ERROR_CODE, DemoErrorConstant.INTERNAL_SERVER_ERROR_MSG), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<FinalResponse> getFinalResponse(Object body) {
		return new ResponseEntity<FinalResponse>(new FinalResponse(DemoErrorConstant.SUCCESS_CODE,DemoErrorConstant.SUCCESS_MSG, body), HttpStatus.OK);
	}
}
