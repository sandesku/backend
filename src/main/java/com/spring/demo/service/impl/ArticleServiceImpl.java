package com.spring.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.demo.constants.DemoErrorConstant;
import com.spring.demo.dao.ArticleDao;
import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Article;
import com.spring.demo.request.ArticleRequest;
import com.spring.demo.response.ArticleResponse;
import com.spring.demo.service.ArticleService;
import com.spring.demo.util.RequestResponseGeneratorUtil;

@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	private ArticleDao articleDao;

	@Override
	public String createArticle(ArticleRequest request) throws DemoException {
		Article article = RequestResponseGeneratorUtil.getArticle(request);
		articleDao.createArticle(article);
		return article.getCode();
	}
	
	@Override
	public String updateArticle(ArticleRequest request) throws DemoException {
		Article article = articleDao.getArticle(request.getCode());
		RequestResponseGeneratorUtil.updateArticle(request, article);
		articleDao.updateArticle(article);
		return article.getCode();
	}

	@Override
	public String removeArticle(String code) throws DemoException {
		Article article = articleDao.getArticle(code);
		articleDao.removeArticle(article);
		return "Article successfully removed";
	}

	@Override
	public ArticleResponse getArticle(String code) throws DemoException {
		Article article = articleDao.getArticle(code);
		article.setVisited(article.getVisited() + 1);
		articleDao.updateArticle(article);
		
		return RequestResponseGeneratorUtil.getArticleResponse(article);
	}

	@Override
	public List<ArticleResponse> getArticleList() throws DemoException {
		List<Article> articleList = articleDao.getArticle();
		if(CollectionUtils.isEmpty(articleList)) {
			logger.error("List of artcile is empty or null");
			throw new DemoException(DemoErrorConstant.FETCH_ARTICLE_ERROR_CODE,DemoErrorConstant.FETCH_ARTICLE_ERROR_MSG);
		}
		return RequestResponseGeneratorUtil.getArticleResponseList(articleList);
	}
}
