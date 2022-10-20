package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class FileUploadPage extends Page {
	private static final String PAGE_URL = "/upload";

	public FileUploadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By upload = By.cssSelector("#file-submit");
	private By header = By.cssSelector("#content div.example h3");
	private By chooseFile = By.cssSelector("#file-upload");

	public void clickUpload() {
		((ProxyDriver) driver).click(upload);
	}

	public void chooseFileSendKeys(String path) {
		((ProxyDriver) driver).sendKeys(chooseFile, path);
	}

	public String getHeaderText() {
		return ((ProxyDriver) driver).getText(header);
	}

}