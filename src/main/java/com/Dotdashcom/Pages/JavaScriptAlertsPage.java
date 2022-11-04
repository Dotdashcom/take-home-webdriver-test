package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class JavaScriptAlertsPage extends GeneralPage {

	public JavaScriptAlertsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private static final String PAGE_URL = "/javascript_alerts";
	private By jsAlertBtn = By.cssSelector("#content > div > ul > li:nth-child(1) > button");
	private By jsConfirmBtn = By.cssSelector("#content > div > ul > li:nth-child(2) > button");
	private By jsPromptBtn = By.cssSelector("#content > div > ul > li:nth-child(3) > button");

	private By jsConfirmMsg = By.cssSelector("p#result");

	public void clickjsAlertBtn() {
		((ProxyDriver) wd).click(jsAlertBtn);
	}

	public void clickjsConfirmBtn() {
		((ProxyDriver) wd).click(jsConfirmBtn);
	}

	public void clickjsjsPromptBtn() {
		((ProxyDriver) wd).click(jsPromptBtn);
	}

	public String getjsAlertMessage() {
		return ((ProxyDriver) wd).textFromAlert();
	}

	public void confirmJsAccept() {

		((ProxyDriver) wd).acceptAlert();
	}

	public String confirmJsMessage() {
		return ((ProxyDriver) wd).textFromAlert();
	}

	public void jsPromptsendKeysGetText(String keys) {
		((ProxyDriver) wd).sendKeys(jsPromptBtn, keys);
		((ProxyDriver) wd).acceptAlert();

	}

	public String confimtPromptMsg() {
		return ((ProxyDriver) wd).getText(jsConfirmMsg);
	}

	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}
}
