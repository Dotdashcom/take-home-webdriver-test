package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class FramesPage extends Page {
	private static final String PAGE_URL = "/frames";

	public FramesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By iframe = By.cssSelector("a[href='/iframe']");

	public IframePage clickOniFrame() {
		((Proxywrapper) driver).click(iframe);
		return new IframePage(driver, true);
	}

}
