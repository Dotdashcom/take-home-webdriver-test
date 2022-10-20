package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class IframePage extends Page{
	private static final String PAGE_URL = "/iframe";

	 public IframePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
}
	 private By box=By.cssSelector("#tinymce");

		public String getTextIframe() {
			((ProxyDriver) driver).switchTo().frame("mce_0_ifr");

		 return ((ProxyDriver) driver).getText(box);
	 }
}