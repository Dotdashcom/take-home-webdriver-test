package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class JavascriptErrorPage extends Page {
	private static final String PAGE_URL = "/javascript_error ";

	public JavascriptErrorPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By iframe = By.cssSelector("a[href='/iframe']");

	public boolean verifyErrorContains(String data) {
		return ((ProxyDriver) driver).printPageErrorsVerifyText(data);
	}
}