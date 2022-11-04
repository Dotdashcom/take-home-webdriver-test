package com.Dotdashcom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class DynamicLoadingPage extends GeneralPage {

	public DynamicLoadingPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private static final String PAGE_URL = "/dynamic_loading/2";
	
	
	private By message = By.cssSelector("#finish > h4");
	private By startBtn = By.cssSelector("#start > button");

	public void clickstartBtn() {
		((ProxyDriver) wd).click(startBtn);
	}

	public String getText() {
		return ((ProxyDriver) wd).getText(message);
	}
	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	private void fail(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}
}