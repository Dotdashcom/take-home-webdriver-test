package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class FramesPage extends Page {
	private static final String PAGE_URL = "/frames";

	public FramesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By iframe = By.cssSelector("a[href='/iframe']");

	public IframePage clickiFrames() {
		((Proxywrapper) driver).click(iframe);
		return new IframePage(driver, true);
	}
}
