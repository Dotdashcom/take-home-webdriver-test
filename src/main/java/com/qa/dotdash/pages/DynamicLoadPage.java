package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class DynamicLoadPage extends Page {
	private static final String PAGE_URL = "/dynamic_loading";

	public DynamicLoadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dynamicLoaded2 = By.cssSelector("#content a:last-of-type");

	public DynamicLoadedPage2 ClickDynamicLoaded2() {
		((Proxywrapper) driver).click(dynamicLoaded2);
		return new DynamicLoadedPage2(driver, true);
	} 

}
