package com.spring.demo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseLogger implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
        
        String requestBody = new String(requestWrapper.getContentAsByteArray());
        logger.info("Request: {} {}",requestWrapper.getRequestURI(), requestBody);
        try {
            chain.doFilter(requestWrapper, responseWrapper);
        } finally {
            String responseBody = new String(responseWrapper.getContentAsByteArray());
            logger.info("Response: {}",responseBody);
            responseWrapper.copyBodyToResponse();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}