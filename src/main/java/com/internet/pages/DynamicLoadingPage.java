package com.internet.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class DynamicLoadingPage extends Page {
	private static final String PAGE_URL = "/dynamic_loading";

	public DynamicLoadingPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dynamicLoaded2 = By.cssSelector("#content a:last-of-type");

	public DynamicLoadedPage2 ClickDynamicLoaded2() {
		((Proxywrapper) driver).click(dynamicLoaded2);
		return new DynamicLoadedPage2(driver, true);
	}

}
