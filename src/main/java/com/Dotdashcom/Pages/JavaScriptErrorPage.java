package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;



public class JavaScriptErrorPage extends GeneralPage {
	private static final String PAGE_URL = "/javascript_error";
	public JavaScriptErrorPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	public boolean verifyError(String data) {
		return ((ProxyDriver) wd).verifyErrorText(data);
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