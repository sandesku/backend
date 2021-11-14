package com.spring.demo.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.spring.demo.model.Article;
import com.spring.demo.model.Body;
import com.spring.demo.request.ArticleBodyRequest;
import com.spring.demo.request.ArticleRequest;
import com.spring.demo.response.ArticleBodyResponse;
import com.spring.demo.response.ArticleResponse;

public class RequestResponseGeneratorUtil {
	
	public static Article getArticle(ArticleRequest request) {
		if(request == null) {
			return null;
		}
		
		List<Body> bodyList = new ArrayList<Body>();
		Article article = new Article();
		article.setCode(String.valueOf(new Date().getTime()));
		if(request.getCode()!=null) {
			article.setCode(request.getCode());
		}
		article.setHeadline(request.getHeadline());
		article.setOverview(request.getOverview());
		article.setConclusion(request.getConclusion());
		for(ArticleBodyRequest articleBodyRequest: request.getBodyList()) {
			Body body = new Body();
			body.setTitle(articleBodyRequest.getTitle());
			body.setContent(articleBodyRequest.getContent());
			body.setStatement(articleBodyRequest.getStatement());
			bodyList.add(body);
		}
		article.setBodyList(bodyList);

		return article;
	}
	
	public static List<ArticleResponse> getArticleResponseList(List<Article> articleList) {
		if(CollectionUtils.isEmpty(articleList)) {
			return null;
		}
		
		List<ArticleResponse> response = new ArrayList<ArticleResponse>();
		for(Article article:articleList) {
			ArticleResponse articleResponse = new ArticleResponse();
			articleResponse.setCode(article.getCode());
			articleResponse.setHeadline(article.getHeadline());
			articleResponse.setOverview(article.getOverview());
			articleResponse.setConclusion(article.getConclusion());
			response.add(articleResponse);
		}
		return response;
	}
	
	public static ArticleResponse getArticleResponse(Article article) {
		if(article == null) {
			return null;
		}
		
		List<ArticleBodyResponse> bodyList = new ArrayList<ArticleBodyResponse>();
		ArticleResponse articleResponse = new ArticleResponse();
		articleResponse.setCode(article.getCode());
		articleResponse.setHeadline(article.getHeadline());
		articleResponse.setOverview(article.getOverview());
		articleResponse.setConclusion(article.getConclusion());
		for(Body body:article.getBodyList()) {
			ArticleBodyResponse articleBodyResponse = new ArticleBodyResponse();
			articleBodyResponse.setContent(body.getContent());
			articleBodyResponse.setStatement(body.getStatement());
			articleBodyResponse.setTitle(body.getTitle());
			bodyList.add(articleBodyResponse);
		}
		articleResponse.setBodyList(bodyList);
		
		return articleResponse;
	}
	
	public static void updateArticle(ArticleRequest request, Article article) {
		article.setHeadline(article.getHeadline());
		article.setOverview(article.getOverview());
		article.setConclusion(article.getConclusion());
		List<Body> bodyList = article.getBodyList();
		List<ArticleBodyRequest> bodyRequestList = request.getBodyList();
		for(int i=0;i<bodyList.size();i++) {
			Body body = bodyList.get(i);
			ArticleBodyRequest bodyRequest = bodyRequestList.get(i);
			body.setTitle(bodyRequest.getTitle());
			body.setContent(bodyRequest.getContent());
			body.setStatement(bodyRequest.getStatement());
		}
	}
}
