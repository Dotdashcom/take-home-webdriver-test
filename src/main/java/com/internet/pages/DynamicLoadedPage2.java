package com.internet.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;
import com.internet.utils.Utils;

public class DynamicLoadedPage2 extends Page {
	private static final String PAGE_URL = "/dynamic_loading/2";

	public DynamicLoadedPage2(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By startButton = By.xpath("//button");
	private By header = By.cssSelector("div.example div:first-of-type h4");

	public void clickStartButton() {

		((Proxywrapper) driver).click(startButton);
	}

	public String getTextHeader() {
		return ((Proxywrapper) driver).getText(header);

	}

}
