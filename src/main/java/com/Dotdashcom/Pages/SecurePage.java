package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;



public class SecurePage extends GeneralPage {
	private static final String PAGE_URL = "/secure";

	public SecurePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private By message=By.id("flash");
	private By header=By.cssSelector("#content h2");
	public String getMessageText() {
		return ((ProxyDriver) wd).getText(message);
	}
	public String getHeaderText() {
		return ((ProxyDriver) wd).getText(header);
	}
	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}
}
