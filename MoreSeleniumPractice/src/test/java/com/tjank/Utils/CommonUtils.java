package com.tjank.Utils;

public class CommonUtils {

	public static void waitForSeconds(int numSecs) {
		try {
			Thread.sleep(numSecs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
