package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class FloatingMenuPage extends Page {

	public FloatingMenuPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By menuHeader = By.cssSelector("div#menu");

	public void scrollToBottom() {
		((ProxyDriver) wd).scroll();
	}

	public boolean isMenuDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(menuHeader);
	}

}
