package com.spring.demo.application;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.annotation.DemoApi;
import com.spring.demo.constants.DemoConstant;
import com.spring.demo.constants.DemoErrorConstant;
import com.spring.demo.exception.DemoException;
import com.spring.demo.service.ConfigService;
import com.spring.demo.util.DemoUtil;

public class AuthenticationInterceptor implements HandlerInterceptor{
	
	@Lazy
	@Autowired
	ConfigService configService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws DemoException {
		if (DispatcherType.REQUEST == request.getDispatcherType()) {
			if (handler instanceof HandlerMethod) {
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				DemoApi demoApi = handlerMethod.getMethodAnnotation(DemoApi.class);
				if (demoApi == null) {
					throw new DemoException(DemoErrorConstant.ANNOTATION_MISSING_CODE, DemoErrorConstant.ANNOTATION_MISSING_MSG);
				}

				if (demoApi.skipAuth()) {
					return true;
				}
				
				if (demoApi.internalAuth()) {
					String internalAuthKeyHeader = request.getHeader(DemoConstant.INTERNAL_AUTH_KEY_HEADER);
					if(DemoUtil.isStringNotEmpty(internalAuthKeyHeader)) {
						String internalAuthKeySystem = configService.getStringValue(DemoConstant.INTERNAL_AUTH_KEY_SYSTEM);
						if(internalAuthKeySystem.equals(internalAuthKeyHeader)) {
							return true;
						}
					}
					throw new DemoException(DemoErrorConstant.INTERNAL_AUTH_MISSING_CODE, DemoErrorConstant.INTERNAL_AUTH_MISSING_MSG);
				}
				
				throw new DemoException(DemoErrorConstant.AUTHORIZATION_CODE, DemoErrorConstant.AUTHORIZATION_CODE_MSG);
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// Logic after business logic is done and just before response sent
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
