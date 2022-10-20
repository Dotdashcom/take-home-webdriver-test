package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class MultipleWindowsPage extends Page {
	private static final String PAGE_URL = "/windows";

	public MultipleWindowsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By link = By.cssSelector("#content a");

	public NewWindowPage clickLink() {
		((ProxyDriver) driver).click(link);
		return new NewWindowPage(driver, true);
	}
}