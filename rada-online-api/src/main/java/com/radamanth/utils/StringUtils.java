package com.radamanth.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringUtils  extends org.springframework.util.StringUtils{

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean  isEmail(final String hex) {
 
		Matcher matcher = pattern.matcher(hex);
		return matcher.matches();
 
	}
}
