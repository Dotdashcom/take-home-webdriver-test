package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class NewWindowPage extends Page {
	private static final String PAGE_URL = "/windows/new";

	public NewWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By header = By.cssSelector(" div.example h3");

	public String getTextHeader() {
		((ProxyDriver) driver).switchToNewTab(header);
		return ((ProxyDriver) driver).getText(header);

	}

}