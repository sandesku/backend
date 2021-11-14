package com.demo.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface RebelApi.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DemoApi {
	/**
	 * Skip auth.
	 */
	boolean skipAuth() default false;

	/**
	 * Internal auth.
	 */
	boolean internalAuth() default false;

}
