package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class IFramePage extends GeneralPage {
	private static final String PAGE_URL = "/iframe";

	 public IFramePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
}
	 private By textBox=By.id("tinymce");
	 private By iFrameLink = By.cssSelector("#content > div > ul > li:nth-child(2) > a");

		public String getTextIframe() {
			((ProxyDriver) wd).click(iFrameLink);
			((ProxyDriver) wd).switchTo().frame("mce_0_ifr");

		 return ((ProxyDriver) wd).getText(textBox);
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
