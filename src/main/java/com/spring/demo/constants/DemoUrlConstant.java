package com.spring.demo.constants;

public class DemoUrlConstant {
	
	public static final String PING = "/v1/ping";
	
	//Article
	public static final String ARTICLE_CREATE_URL = "/v1/article/create";
	public static final String ARTICLE_UPDATE_URL = "/v1/article/update";
	public static final String ARTICLE_REMOVE_URL= "/v1/article/remove/{code}";
	public static final String ARTICLE_FETCH_URL = "/v1/article/get/{code}";
	public static final String ARTICLE_FETCH_LIST_URL = "/v1/article/list";
}
