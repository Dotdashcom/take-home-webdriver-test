package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class FramePage extends Page {
	private static final String PAGE_URL = "/frames";

	public FramePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By iframe = By.cssSelector("a[href='/iframe']");

	public IframePage clickiFrames() {
		((ProxyDriver) driver).click(iframe);
		return new IframePage(driver, true);
	}
}
