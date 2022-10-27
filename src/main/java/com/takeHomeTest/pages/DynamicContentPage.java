package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class DynamicContentPage extends Page {

	public DynamicContentPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By secondPara = By.cssSelector("#content div.row #content div.row:nth-of-type(2) div.large-10");

	public String textFromPara() {
		return ((ProxyDriver) wd).getText(secondPara);
	}

	public void refereshPage() {
		((ProxyDriver) wd).navigate().refresh();
	}

}
