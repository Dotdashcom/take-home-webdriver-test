package com.internet.pages;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class DynamicPageLoading extends Page {
	private static final String PAGE_URL = "/dynamic_loading";

	public DynamicPageLoading(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dynamicLoaded2 = By.cssSelector("#content a:last-of-type");

	public DynamicPageLoaded ClickDynamicLoaded2() {
		((ProxyDriver) driver).click(dynamicLoaded2);
		return new DynamicPageLoaded(driver, true);
	}

}
