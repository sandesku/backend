package com.spring.demo.util;

public class DemoUtil {
	
	public static boolean isStringEmpty(String value) {
		if (value == null || value.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isStringNotEmpty(String value) {
		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		return true;
	}
}
