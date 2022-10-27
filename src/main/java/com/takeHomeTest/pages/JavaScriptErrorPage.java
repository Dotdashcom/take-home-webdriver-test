package com.takeHomeTest.pages;

import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class JavaScriptErrorPage extends Page {

	public JavaScriptErrorPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	public boolean verifyError(String data) {
		return ((ProxyDriver) wd).ErrorsVerifyText(data);
	}

}
