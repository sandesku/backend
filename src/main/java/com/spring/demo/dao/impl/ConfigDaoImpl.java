package com.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.demo.constants.DemoErrorConstant;
import com.spring.demo.dao.ConfigDao;
import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Config;

@Repository
public class ConfigDaoImpl implements ConfigDao{
	private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Config getConfig(String name) throws DemoException {
		Config config = null;
		try {
			config = entityManager.createQuery("select c from Config c where status = 'Active' and name = :name", Config.class).setParameter("name", name).getSingleResult();
		}catch(Exception e) {
			logger.error("Config not found for name {}", name);
			throw new DemoException(DemoErrorConstant.FETCH_CONFIG_ERROR_CODE, DemoErrorConstant.FETCH_CONFIG_ERROR_MSG);
		}
		return config;
	}

	@Override
	public List<Config> getAllConfig() throws DemoException {
		List<Config> configList = null;
		try {
			configList = entityManager.createQuery("select c from Config c where status = 'Active'", Config.class).getResultList();
		}catch(Exception e) {
			logger.error("Config not found");
			throw new DemoException(DemoErrorConstant.FETCH_CONFIG_ERROR_CODE, DemoErrorConstant.FETCH_CONFIG_ERROR_MSG);
		}
		return configList;
	}
}
