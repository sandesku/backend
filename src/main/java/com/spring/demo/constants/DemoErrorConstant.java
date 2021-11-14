package com.spring.demo.constants;

public class DemoErrorConstant {
	
	public static final Integer SUCCESS_CODE = 0;
	public static final String SUCCESS_MSG = "Success";
	
	public static final Integer INTERNAL_SERVER_ERROR_CODE = 500;
	public static final String INTERNAL_SERVER_ERROR_MSG = "Oops! Something went wrong. Please contact admin for any help";
	
	public static final Integer SAVE_ARTICLE_ERROR_CODE = 1000;
	public static final String SAVE_ARTICLE_ERROR_MSG = "Failed to save Article";
	
	public static final Integer FETCH_ARTICLE_ERROR_CODE = 1001;
	public static final String FETCH_ARTICLE_ERROR_MSG = "Article not found";
	
	public static final Integer UPDATE_ARTICLE_ERROR_CODE = 1002;
	public static final String UPDATE_ARTICLE_ERROR_MSG = "Article not found for update";
	
	public static final Integer FETCH_CONFIG_ERROR_CODE = 1003;
	public static final String FETCH_CONFIG_ERROR_MSG = "Config not found";
	
	public static final Integer ANNOTATION_MISSING_CODE = 1004;
	public static final String ANNOTATION_MISSING_MSG = "Annotataion is missing";
	
	public static final int AUTHORIZATION_CODE = 1005;
	public static final String AUTHORIZATION_CODE_MSG = "Not authorized to access this service!!";
	
	public static final int INTERNAL_AUTH_MISSING_CODE = 1006;
	public static final String INTERNAL_AUTH_MISSING_MSG = "internal_auth_key is missing or blank";
}
