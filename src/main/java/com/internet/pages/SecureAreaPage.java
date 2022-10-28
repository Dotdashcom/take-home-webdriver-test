package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class SecureAreaPage extends Page {
	private static final String PAGE_URL = "/secure";

	public SecureAreaPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private By message=By.cssSelector("#flash");
	private By header=By.cssSelector("#content h2");
	public String getMessageText() {
		return ((Proxywrapper) driver).getText(message);
	}
	public String getHeaderText() {
		return ((Proxywrapper) driver).getText(header);
	}
}
