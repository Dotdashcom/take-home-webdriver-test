package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class DynamicContentPage extends Page {
	private static final String PAGE_URL = "/dynamic_content";

	public DynamicContentPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By content2 = By.cssSelector("#content div.row #content div.row:nth-of-type(2) div.large-10");

	public String getTextOfContent2() {
		return ((Proxywrapper) driver).getText(content2);
	}

	public String getTextContent2AfterRefresh() {
		((Proxywrapper) driver).navigate().refresh();
		return ((Proxywrapper) driver).getText(content2);
	}
}
