package com.dotdash.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ProxyDriver;

public class DynamicControlsPage extends Page {
	private static final String PAGE_URL = "/dynamic_controls";

	public DynamicControlsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By removeOrAddButton = By.cssSelector("div #checkbox-example button");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By removedmessage = By.cssSelector("#checkbox-example #message");
	private By enableButton = By.cssSelector("div.example #input-example button");
	private By textBox = By.cssSelector("div.example #input-example input");

	public void ClickRemoveOrAddButton() {
		((ProxyDriver) driver).click(removeOrAddButton);
	}

	public By getRemoveOrAddButton() {
		return removeOrAddButton;
	}

	public void setRemoveOrAddButton(By removeOrAddButton) {
		this.removeOrAddButton = removeOrAddButton;
	}

	public boolean isCheckBoxDisplyed() {
		return ((ProxyDriver) driver).isDisplayed(checkBox);
	}

	public String getMessageText(String value) {

		return ((ProxyDriver) driver).getText(removedmessage);
	}

	public By getEnableButton() {
		return enableButton;
	}

	public void setEnableButton(By enableButton) {
		this.enableButton = enableButton;
	}

	public void ClickEnableButton() {
		((ProxyDriver) driver).click(enableButton);
	}

	public String getRemoveOrAddButtonText() {

		return ((ProxyDriver) driver).getText(removeOrAddButton);
	}

	public String getEnableButtonText() {

		return ((ProxyDriver) driver).getText(enableButton);
	}

	public boolean isTestBoxEnabled() {
		return ((ProxyDriver) driver).isEnabled(textBox);
	}
}
