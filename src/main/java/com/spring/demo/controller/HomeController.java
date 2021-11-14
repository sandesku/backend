package com.spring.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.annotation.DemoApi;
import com.spring.demo.constants.DemoUrlConstant;
import com.spring.demo.exception.DemoException;
import com.spring.demo.response.FinalResponse;
import com.spring.demo.util.FinalResponseUtil;

@RestController
public class HomeController {

	@DemoApi(skipAuth = true)
	@RequestMapping(path = DemoUrlConstant.PING, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FinalResponse> ping() throws DemoException {
		return FinalResponseUtil.getFinalResponse("Pong");
	}
}
