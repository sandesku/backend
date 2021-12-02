package com.spring.demo.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.spring.demo.model.Article;
import com.spring.demo.model.ArticleBody;
import com.spring.demo.request.ArticleBodyRequest;
import com.spring.demo.request.ArticleRequest;
import com.spring.demo.response.ArticleBodyResponse;
import com.spring.demo.response.ArticleResponse;

public class RequestResponseGeneratorUtil {

	public static Article getArticle(ArticleRequest request) {
		if (request == null) {
			return null;
		}

		List<ArticleBody> articleBodyList = new ArrayList<ArticleBody>();
		Article article = new Article();
		article.setCode(String.valueOf(new Date().getTime()));
		article.setHeadline(request.getHeadline());
		article.setOverview(request.getOverview());
		article.setConclusion(request.getConclusion());
		for (ArticleBodyRequest articleBodyRequest : request.getArticleBodyList()) {
			ArticleBody articleBody = new ArticleBody();
			articleBody.setTitle(articleBodyRequest.getTitle());
			articleBody.setContent(articleBodyRequest.getContent());
			articleBody.setStatement(articleBodyRequest.getStatement());
			articleBodyList.add(articleBody);
		}
		article.setArticleBodyList(articleBodyList);

		return article;
	}

	public static List<ArticleResponse> getArticleResponseList(List<Article> articleList) {
		if (CollectionUtils.isEmpty(articleList)) {
			return null;
		}

		List<ArticleResponse> response = new ArrayList<ArticleResponse>();
		for (Article article : articleList) {
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
		if (article == null) {
			return null;
		}

		List<ArticleBodyResponse> artcielBodyList = new ArrayList<ArticleBodyResponse>();
		ArticleResponse articleResponse = new ArticleResponse();
		articleResponse.setCode(article.getCode());
		articleResponse.setHeadline(article.getHeadline());
		articleResponse.setOverview(article.getOverview());
		articleResponse.setConclusion(article.getConclusion());
		for (ArticleBody articleBody : article.getArticleBodyList()) {
			ArticleBodyResponse articleBodyResponse = new ArticleBodyResponse();
			articleBodyResponse.setContent(articleBody.getContent());
			articleBodyResponse.setStatement(articleBody.getStatement());
			articleBodyResponse.setTitle(articleBody.getTitle());
			artcielBodyList.add(articleBodyResponse);
		}
		articleResponse.setArticleBodyList(artcielBodyList);

		return articleResponse;
	}

	public static void updateArticle(ArticleRequest request, Article article) {
		article.setHeadline(request.getHeadline());
		article.setOverview(request.getOverview());
		article.setConclusion(request.getConclusion());
		List<ArticleBody> articleBodyList = article.getArticleBodyList();
		List<ArticleBodyRequest> requestBodyList = request.getArticleBodyList();
		for (int i = 0; i < articleBodyList.size(); i++) {
			ArticleBody articleBody = articleBodyList.get(i);
			ArticleBodyRequest requestBody = requestBodyList.get(i);
			articleBody.setTitle(requestBody.getTitle());
			articleBody.setContent(requestBody.getContent());
			articleBody.setStatement(requestBody.getStatement());
		}
	}
}
