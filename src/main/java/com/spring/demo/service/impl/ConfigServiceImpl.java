package com.spring.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.ConfigDao;
import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Config;
import com.spring.demo.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService{
	private final Map<String, String> configMap = new HashMap<String, String>();
	
	@Lazy
	@Autowired
	private ConfigDao configDao;

	@Override
	public String getStringValue(String name) throws DemoException {
		if(!configMap.containsKey(name)) {
			Config config = configDao.getConfig(name);
			configMap.put(name, config.getValue());
		}
		return String.valueOf(configMap.get(name));
	}

	@Override
	public Integer getIntegerValue(String name) throws DemoException {
		if(!configMap.containsKey(name)) {
			Config config = configDao.getConfig(name);
			configMap.put(name, config.getValue());
		}
		return Integer.valueOf(configMap.get(name));
	}
}
