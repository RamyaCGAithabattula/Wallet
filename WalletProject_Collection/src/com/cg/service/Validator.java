package com.cg.service;

public interface Validator {
	String aidpattern="[1-9][0-9]{2}";
	String mobilepattern="[1-9][0-9]{9}";
	String ahpattern="[A-Z][a-zA-Z ']*";
	String balpattern="[1-9][0-9].*";
	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}
}
