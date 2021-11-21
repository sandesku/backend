package com.spring.demo.response;

import java.util.List;

public class ArticleResponse {
	private String code;
	
	private String headline;
	
	private String overview;
	
	private String conclusion;
	
	List<ArticleBodyResponse> articleBodyList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public List<ArticleBodyResponse> getArticleBodyList() {
		return articleBodyList;
	}

	public void setArticleBodyList(List<ArticleBodyResponse> articleBodyList) {
		this.articleBodyList = articleBodyList;
	}
}
