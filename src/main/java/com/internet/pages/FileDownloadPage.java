package com.internet.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class FileDownloadPage extends Page {
	private static final String PAGE_URL = "/download";

	public FileDownloadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By link = By.cssSelector("#content div.example a");

	public void clickLink() {
		((ProxyDriver) driver).click(link);
	}
}
