package com.utils;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CommonMethods extends BaseClass {

	/**
	 * Method creates WebDriverWait object
	 * 
	 * @return WebDriverWait
	 */
	public static WebDriverWait getWait() {
		return new WebDriverWait(driver, 15);
	}

	/**
	 * Explicit wait for element clickability
	 * 
	 * @param element
	 * @return WebElement
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Method clicks on element
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element).click();
	}

	/**
	 * Explicit wait for element visibility
	 * 
	 * @param element
	 * @return WebElement
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method sends text to the text box
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		waitForVisibility(element).clear();
		element.sendKeys(text);
	}
	
	/**
	 * Method switches focus to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
}
