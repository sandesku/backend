package com.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.demo.constants.DemoErrorConstant;
import com.spring.demo.dao.ArticleDao;
import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao{
	private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createArticle(Article article) throws DemoException {
		try {
			entityManager.persist(article);
		}catch(Exception e) {
			logger.error("Failed to save the article");
			throw new DemoException(DemoErrorConstant.SAVE_ARTICLE_ERROR_CODE, DemoErrorConstant.SAVE_ARTICLE_ERROR_MSG);
		}
	}
	
	@Override
	@Transactional
	public void updateArticle(Article article) throws DemoException {
		try {
			entityManager.merge(article);
		}catch(Exception e) {
			logger.error("Article not found for update");
			throw new DemoException(DemoErrorConstant.UPDATE_ARTICLE_ERROR_CODE, DemoErrorConstant.UPDATE_ARTICLE_ERROR_MSG);
		}
	}
	
	@Override
	@Transactional
	public void removeArticle(Article article) throws DemoException {
		try {
			entityManager.remove(article);
		}catch(Exception e) {
			logger.error("Article not found for remove");
			throw new DemoException(DemoErrorConstant.UPDATE_ARTICLE_ERROR_CODE, DemoErrorConstant.UPDATE_ARTICLE_ERROR_MSG);
		}
	}

	@Override
	public Article getArticle(String code) throws DemoException {
		Article response = null;
		try {
			response = entityManager.createQuery("select a from Article a where status = 'active' and code = :code", Article.class).setParameter("code", code).getSingleResult();
		}catch(Exception e) {
			logger.error("Article not found for code {}", code);
			throw new DemoException(DemoErrorConstant.FETCH_ARTICLE_ERROR_CODE, DemoErrorConstant.FETCH_ARTICLE_ERROR_MSG);
		}
		return response;
	}

	@Override
	public List<Article> getArticle() throws DemoException {
		List<Article> response = null;
		try {
			response = entityManager.createQuery("select a from Article a where status = 'active'", Article.class).getResultList();
		}catch(Exception e) {
			logger.error("Article not found");
			throw new DemoException(DemoErrorConstant.FETCH_ARTICLE_ERROR_CODE, DemoErrorConstant.FETCH_ARTICLE_ERROR_MSG);
		}
		return response; 
	}
}
