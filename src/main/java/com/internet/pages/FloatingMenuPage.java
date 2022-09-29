package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class FloatingMenuPage extends Page {

	public FloatingMenuPage(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);
	}

	private By floatingMenu = By.cssSelector("div.example #menu");

	public boolean isFloatingMenuDisplayed() {
		return ((Proxywrapper) driver).isDisplayed(floatingMenu);
	}

	public void scrollToBottom() {
		((Proxywrapper) driver).scrollDownUsingJavaScript();
	}
}
