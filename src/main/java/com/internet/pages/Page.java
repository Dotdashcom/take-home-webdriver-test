package com.internet.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Page extends GeneralPage {
	public Page(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);
		if (waitForPageToLoad) {
			this.waitForPageToLoad();
		}
	}

	public final static int DEFAULT_TIME_FOR_PAGE_TO_LOAD = 50;
	protected String wdWindowHandle;
	protected Map<String, String> query;
	private static final String URL = "http://localhost:7080";

	private String getDocumentReadyState() {

		try {
			return (String) ((JavascriptExecutor) driver).executeAsyncScript("return document.readyState");
		} catch (WebDriverException e) {
			return null;
		}
	}

	protected String getDomain() {
		return URL;

	}

	public String getPageURL() {
		return getDomain();
	}

	public void waitForPageToLoad() {
		this.isLoaded();
	}

	@Override
	public Page get() {
		super.get();
		this.waitForPageToLoad();
		return this;

	}

	@Override
	protected void isLoaded() throws Error {

	}

}