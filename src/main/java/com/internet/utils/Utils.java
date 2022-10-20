package com.internet.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String generateRandomInput() {
		String input = RandomStringUtils.randomNumeric(4);

		return input;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}
}