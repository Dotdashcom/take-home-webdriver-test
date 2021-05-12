package com.dotdash.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtil {

	/**
	 * Close browser window at end of a test method
	 */
	public static void closeBrowserWindow(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the current Y position of the HTML page
	 */
	public static long getPageYOffset(WebDriver driver) {
		final String js = "return window.pageYOffset;";
		return getReturnValueAsLong(((JavascriptExecutor) driver).executeScript(js));
	}

	/**
	 * Get the Y position of an element within the visible viewport. 
	 */
	public static long getElementYPositionOnViewport(WebDriver driver, WebElement element) {
		final String js = "var elem = arguments[0]; return elem.getBoundingClientRect().top;";
		Object yPosition = ((JavascriptExecutor) driver).executeScript(js, element);
		return getReturnValueAsLong(yPosition);
	}
	
	/**
	 * Get the visible area height of a browser window. 
	 */
	public static long getViewportHeight(WebDriver driver) {
		final String js = "return Math.max(document.documentElement.clientHeight || 0, window.innerHeight || 0);";
		return getReturnValueAsLong(((JavascriptExecutor) driver).executeScript(js));
	}

	private static Long getReturnValueAsLong(Object jsReturnVal) {
		if (jsReturnVal instanceof Double) {
			return ((Double) jsReturnVal).longValue();
		} else {
			return ((Long) jsReturnVal).longValue();
		}
	}	
}
