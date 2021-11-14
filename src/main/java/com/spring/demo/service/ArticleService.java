package com.spring.demo.service;

import java.util.List;

import com.spring.demo.exception.DemoException;
import com.spring.demo.request.ArticleRequest;
import com.spring.demo.response.ArticleResponse;

public interface ArticleService {
	
	public String createArticle(ArticleRequest request) throws DemoException;
	
	public String updateArticle(ArticleRequest request) throws DemoException;
	
	public String removeArticle(String code) throws DemoException;
	
	public ArticleResponse getArticle(String code) throws DemoException;
	
	public List<ArticleResponse> getArticleList() throws DemoException;

}
