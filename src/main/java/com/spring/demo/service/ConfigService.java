package com.spring.demo.service;

import com.spring.demo.exception.DemoException;

public interface ConfigService {
	
	public String getStringValue(String name) throws DemoException;
	
	public Integer getIntegerValue(String name) throws DemoException;

}
