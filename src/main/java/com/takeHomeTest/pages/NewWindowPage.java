package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class NewWindowPage extends Page {

	public NewWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By header = By.cssSelector("h3");

	public String getHeader() {
		((ProxyDriver) wd).switchToNewTab(header);   // proxy method to switch to new tab
		return ((ProxyDriver) wd).getText(header);
	}

}
