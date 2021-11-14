package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.exception.DemoException;
import com.spring.demo.model.Article;

public interface ArticleDao {
	public void createArticle(Article article) throws DemoException;
	
	public void updateArticle(Article article) throws DemoException;
	
	public void removeArticle(Article article) throws DemoException;
	
	public Article getArticle(String code) throws DemoException;
	
	public List<Article> getArticle() throws DemoException;
}
