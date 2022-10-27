package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class DynamicLoadingPage extends Page {

	public DynamicLoadingPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By text = By.cssSelector("div#finish h4");
	private By startBtn = By.cssSelector("div#start button");

	public void clickstartBtn() {
		((ProxyDriver) wd).click(startBtn);
	}

	public String getTextHelloWorld() {
		return ((ProxyDriver) wd).getText(text);
	}

}
