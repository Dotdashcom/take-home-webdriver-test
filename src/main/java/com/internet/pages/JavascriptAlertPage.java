package com.internet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.base.Baseclass;
import com.internet.utils.Proxywrapper;
import com.internet.utils.Utils;

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
		((Proxywrapper) driver).click(jsAlert);

	}

	public void clickjsConfirm() {
		((Proxywrapper) driver).click(jsConfirm);

	}

	public void clickjsPrompt() {
		((Proxywrapper) driver).click(jsPrompt);

	}

	public String getjsAlertMessage() {
		clickjsAlert();
		return ((Proxywrapper) driver).alertText();
	}

	public String getjsConfirmMessage() {
		clickjsConfirm();
		return ((Proxywrapper) driver).alertText();
	}

	public String getjsPromptMessage() {

		return ((Proxywrapper) driver).getText(jsPromptTextBox).replace("You entered:", "").trim();
	}

	public void acceptJsConfirm() {

		((Proxywrapper) driver).acceptAlert();
	}

	public String jsPromptsendKeysGetText(String keys) {
		clickjsPrompt();
		((Proxywrapper) driver).sendKeysAlert(jsPrompt, keys);
		((Proxywrapper) driver).acceptAlert();

		return getjsPromptMessage();
	}
}
