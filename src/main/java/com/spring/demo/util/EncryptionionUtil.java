package com.spring.demo.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.demo.application.RequestResponseLogger;

public class EncryptionionUtil {
	private static final Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);
	
	public static String getSHA256Encryption(String password) {
		MessageDigest digest = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Failed to get MessageDigest");
		}
		
		byte[] byteEncode = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(byteEncode);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static void main(String[] args) {
		System.out.print(getSHA256Encryption("K1san01_45"));
	}
}
