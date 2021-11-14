package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.annotation.DemoApi;
import com.spring.demo.constants.DemoUrlConstant;
import com.spring.demo.exception.DemoException;
import com.spring.demo.request.ArticleRequest;
import com.spring.demo.response.FinalResponse;
import com.spring.demo.service.ArticleService;
import com.spring.demo.util.FinalResponseUtil;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@DemoApi(internalAuth = true)
    @RequestMapping(path = DemoUrlConstant.ARTICLE_CREATE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalResponse> createArticle(@RequestBody ArticleRequest createArticleRequest) throws DemoException {
    	return FinalResponseUtil.getFinalResponse(articleService.createArticle(createArticleRequest));
    }
    
	@DemoApi(internalAuth = true)
    @RequestMapping(path = DemoUrlConstant.ARTICLE_UPDATE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalResponse> updateArticle(@RequestBody ArticleRequest request) throws DemoException {
    	return FinalResponseUtil.getFinalResponse(articleService.updateArticle(request));
    }
    
	@DemoApi(internalAuth = true)
    @RequestMapping(path = DemoUrlConstant.ARTICLE_REMOVE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalResponse> removeArticle(@PathVariable String code) throws DemoException {
    	return FinalResponseUtil.getFinalResponse(articleService.removeArticle(code));
    }
    
	@DemoApi(internalAuth = true)
    @RequestMapping(path = DemoUrlConstant.ARTICLE_FETCH_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalResponse> getArticle(@PathVariable String code) throws DemoException {
        return FinalResponseUtil.getFinalResponse(articleService.getArticle(code));
    }
    
	@DemoApi(internalAuth = true)
    @RequestMapping(path = DemoUrlConstant.ARTICLE_FETCH_LIST_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalResponse> getArticleList() throws DemoException {
    	return FinalResponseUtil.getFinalResponse(articleService.getArticleList());
    }
}
