package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.takeHomeTest.Utils.ProxyDriver;

public class DynamicControls extends Page {

	public DynamicControls(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By enableBtn = By.cssSelector("div.example #input-example button");
	private By textBox = By.cssSelector("div.example #input-example input");
	private By removeAddBtn = By.cssSelector("div #checkbox-example button");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By removedMsg = By.cssSelector("#checkbox-example #message");

	public void ClickRemoveAddButton() {
		((ProxyDriver) wd).click(removeAddBtn);
	}

	public By getRemoveOrAddButton() {
		return removeAddBtn;
	}

	public void setRemoveOrAddButton(By removeOrAddButton) {
		this.removeAddBtn = removeOrAddButton;
	}

	public boolean isCheckBoxDisplyed() {
		return ((ProxyDriver) wd).isDisplayed(checkBox);
	}

	public String getMessageText(String value) {
		if (value.equals("Disappear")) {
			new WebDriverWait(wd, 10).until(ExpectedConditions.invisibilityOfElementLocated(checkBox));

		} else {
			new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		}
		return ((ProxyDriver) wd).getText(removedMsg);
	}

	public By getEnableButton() {
		return enableBtn;
	}

	public void setEnableButton(By enableButton) {
		this.enableBtn = enableButton;
	}

	public void ClickEnableButton() {
		((ProxyDriver) wd).click(enableBtn);
	}

	public String getRemoveOrAddButtonText() {

		return ((ProxyDriver) wd).getText(removeAddBtn);
	}

	public String getEnableButtonText() {

		return ((ProxyDriver) wd).getText(enableBtn);
	}

	public boolean isTestBoxEnabled() {
		return ((ProxyDriver) wd).isEnabled(textBox);
	}

}
