package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class IframePage extends Page {

	public IframePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private By Iframe = By.cssSelector("body#tinymce p");

	
	public String getTextFromIframe() {
		((ProxyDriver) wd).switchTo().frame("mce_0_ifr");   // switching to frame

		return ((ProxyDriver) wd).getText(Iframe);
	}

}
