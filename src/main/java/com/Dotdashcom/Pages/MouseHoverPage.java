package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class MouseHoverPage extends GeneralPage {
	private static final String PAGE_URL = "/hovers";

	public MouseHoverPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By firstImage = By.cssSelector("#content > div > div:nth-child(3) > img");
	private By secondImage = By.cssSelector("#content > div > div:nth-child(4) > img");
	private By thirdImage = By.cssSelector("#content > div > div:nth-child(5) > img");
	private By firstHeader = By.cssSelector("#content > div > div:nth-child(3) > div > h5");
	private By secondHeader = By.cssSelector("#content > div > div:nth-child(4) > div > h5");
	private By thirdHeader = By.cssSelector("#content > div > div:nth-child(5) > div > h5");

	public void mouseHoverFirstImage() {
		((ProxyDriver) wd).moveToElement(firstImage);
	}

	public void mouseHoverSecondImage() {
		((ProxyDriver) wd).moveToElement(secondImage);
	}

	public void mouseHoverThirdImage() {
		((ProxyDriver) wd).moveToElement(thirdImage);
	}

	public boolean IsfirstTestDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(firstHeader);
	}

	public boolean IsSecondTextDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(secondHeader);
	}

	public boolean IsThirdTextDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(thirdHeader);
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
