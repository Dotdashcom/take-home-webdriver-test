package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class FileUploadPage extends GeneralPage {
	private static final String PAGE_URL = "/upload";

	public FileUploadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By uploadBtn = By.id("file-submit");
	private By sucessMessage = By.cssSelector("#content > div > h3");
	private By chooseFileBtn = By.id("file-upload");

	public void clickUpload() {
		((ProxyDriver) wd).click(uploadBtn);
	}

	public void chooseFileSendKeys(String path) {
		((ProxyDriver) wd).sendKeys(chooseFileBtn, path);
	}

	public String getHeaderText() {
		return ((ProxyDriver) wd).getText(sucessMessage);
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
