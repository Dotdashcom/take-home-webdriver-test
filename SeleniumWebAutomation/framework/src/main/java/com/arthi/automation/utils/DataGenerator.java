package com.arthi.automation.utils;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public final class DataGenerator {

	private DataGenerator() {}
	
	/**
	 * Get the Generated Unique ID of 32 chars long
	 * @return
	 */
	public static String getUniqueID() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	
	/**
	 * Get Generated Random Numeric of given Length
	 * @param length
	 * @return
	 */
	public static String getGeneratedNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	
	/**
	 * Get Generated Alphabets of given Length
	 * @param length
	 * @return
	 */
	public static String getGeneratedAlphabets(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	/**
	 * Get Generated AlphaNumeric of Given Length
	 * @param length
	 * @return
	 */
	public static String getGeneratedAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	/**
	 * Get Generated Unique Email ID based on given Prefix, Seperator and Domain
	 * format: <prefix><seperator><randomChar(9)>@<domain>
	 * @param prefix
	 * @param seperator
	 * @param domain
	 * @return
	 */
	public static String getGeneratedEmail(final String prefix, final String seperator, final String domain) {
		return String.join(seperator, prefix, getGeneratedAlphabets(9).toLowerCase()).concat("@").concat(domain);
	}
	
	public static <T> T getDataObjectPopulated(T type, Object... values) {
		
		return type;
	}
}
