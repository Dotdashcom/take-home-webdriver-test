package com.internet.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;
import com.internet.utils.Utils;

public class DynamicPageLoaded extends Page {
	private static final String PAGE_URL = "/dynamic_loading/2";

	public DynamicPageLoaded(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By startButton = By.xpath("//button");
	private By header = By.cssSelector("div.example div:first-of-type h4");

	public void clickStartButton() {

		((ProxyDriver) driver).click(startButton);
	}

	public String getTextHeader() {
		return ((ProxyDriver) driver).getText(header);

	}

}