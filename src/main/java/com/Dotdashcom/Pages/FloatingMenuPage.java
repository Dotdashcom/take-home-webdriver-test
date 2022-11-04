package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class FloatingMenuPage extends GeneralPage {

	public FloatingMenuPage(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);
	}
	private static final String PAGE_URL = "/floating_menu";
	private By floatingMenu = By.id("menu");

	public boolean isFloatingMenuDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(floatingMenu);
	}

	public void scrollToBottom() {
		((ProxyDriver) wd).scrollDownUsingJavaScript();
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
