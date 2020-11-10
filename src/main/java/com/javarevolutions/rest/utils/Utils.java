package com.javarevolutions.rest.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

	public static String getSHA256(String header) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md=MessageDigest.getInstance("SHA-256");
		md.update(header.getBytes("UTF-8"));
		StringBuffer sb= new StringBuffer();
		byte[] mdbytes=md.digest();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i]&0xff)+0x100,16));
		}
		return sb.toString();
	}
	
}
