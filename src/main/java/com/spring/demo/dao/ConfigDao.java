package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Config;

public interface ConfigDao {
	
	public Config getConfig(String name) throws DemoException;
	
	public List<Config> getAllConfig() throws DemoException;

}
