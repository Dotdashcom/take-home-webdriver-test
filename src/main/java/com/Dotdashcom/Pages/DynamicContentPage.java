package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.*;

public class DynamicContentPage extends GeneralPage {
	private static final String PAGE_URL = "/dynamic_content";

	public DynamicContentPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By para3 = By.cssSelector("#content > div:nth-child(7) > div.large-10.columns");

	public String getTextOfPara3() {
		return ((ProxyDriver) wd).getText(para3);
	}

	public String getTextPara3AfterRefresh() {
		((ProxyDriver) wd).navigate().refresh();
		return ((ProxyDriver) wd).getText(para3);
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
