package com.dotdash.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ProxyDriver;

public class JavascriptAlertPage extends Page {
	private static final String PAGE_URL = "/frames";

	public JavascriptAlertPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By jsAlert = By.cssSelector("div.example li:first-of-type button");
	private By jsConfirm = By.cssSelector("div.example li:nth-of-type(2) button");
	private By jsPrompt = By.cssSelector("div.example li:last-of-type button");
	private By jsPromptTextBox = By.cssSelector("#result");

	public void clickjsAlert() {
		((ProxyDriver) driver).click(jsAlert);

	}

	public void clickjsConfirm() {
		((ProxyDriver) driver).click(jsConfirm);

	}

	public void clickjsPrompt() {
		((ProxyDriver) driver).click(jsPrompt);

	}

	public String getjsAlertMessage() {
		clickjsAlert();
		return ((ProxyDriver) driver).alertText();
	}

	public String getjsConfirmMessage() {
		clickjsConfirm();
		return ((ProxyDriver) driver).alertText();
	}

	public String getjsPromptMessage() {

		return ((ProxyDriver) driver).getText(jsPromptTextBox).replace("You entered:", "").trim();
	}

	public void acceptJsConfirm() {

		((ProxyDriver) driver).acceptAlert();
	}

	public String jsPromptsendKeysGetText(String keys) {
		clickjsPrompt();
		((ProxyDriver) driver).sendKeysAlert(jsPrompt, keys);
		((ProxyDriver) driver).acceptAlert();

		return getjsPromptMessage();
	}
}
