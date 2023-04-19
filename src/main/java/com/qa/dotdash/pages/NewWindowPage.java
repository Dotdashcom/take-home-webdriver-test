package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class NewWindowPage extends Page {
	private static final String PAGE_URL = "/windows/new";

	public NewWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By header = By.cssSelector(" div.example h3");

	public String getTextHeader() {
		((Proxywrapper) driver).switchToNewTab(header);
		return ((Proxywrapper) driver).getText(header);

	}

}
