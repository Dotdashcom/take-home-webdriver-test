package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

;

public class OpenNewWindowPage extends GeneralPage {
	private static final String PAGE_URL = "/windows/new";
	
	public OpenNewWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}

	private By message = By.cssSelector("#content > div > a");
	private By clickOnLink = By.cssSelector("#content a");

	public String getTextHeader() {
		String parentWindowHandle=((ProxyDriver) wd).getWindowHandle();
		((ProxyDriver) wd).click(clickOnLink);
		Set<String> windowHandles=((ProxyDriver) wd).getWindowHandles();
		for(String handle:windowHandles) {
			if(parentWindowHandle!=handle) {
				wd.switchTo().window(handle);
			}
		}
		return ((ProxyDriver) wd).getText(message);

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
