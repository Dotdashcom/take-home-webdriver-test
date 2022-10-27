package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class JavaScriptAlertsPage extends Page {

	public JavaScriptAlertsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By jsAlertBtn = By.cssSelector("div.example  li:nth-of-type(1) button");
	private By jsConfirmBtn = By.cssSelector("div.example  li:nth-of-type(2) button");
	private By jsPromptBtn = By.cssSelector("div.example  li:nth-of-type(3) button");

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
		return ((ProxyDriver) wd).alertText();
	}

	public void confirmJsAccept() {

		((ProxyDriver) wd).acceptAlert();
	}

	public String confirmJsMessage() {
		return ((ProxyDriver) wd).alertText();
	}

	public void jsPromptsendKeysGetText(String keys) {
		((ProxyDriver) wd).sendKeysAlert(jsPromptBtn, keys);
		((ProxyDriver) wd).acceptAlert();

	}

	public String confimtPromptMsg() {
		return ((ProxyDriver) wd).getText(jsConfirmMsg);
	}

}
