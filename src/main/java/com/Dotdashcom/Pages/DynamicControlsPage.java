package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;

public class DynamicControlsPage extends GeneralPage {
	private static final String PAGE_URL = "/dynamic_controls";

	public DynamicControlsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By removeButton = By.cssSelector("#checkbox-example > button");
	private By checkBox = By.cssSelector("#checkbox:last-of-type");
	private By removedmessage = By.cssSelector("#message:first-of-type");
	private By enableButton = By.cssSelector("#input-example button");
	private By textBox = By.cssSelector("#input-example > input[type=text]");

	public void ClickRemoveOrAddButton() {
		((ProxyDriver) wd).click(removeButton);
	}

	public By getRemoveOrAddButton() {
		return removeButton;
	}

	public void setRemoveOrAddButton(By removeOrAddButton) {
		this.removeButton = removeOrAddButton;
	}

	public boolean isCheckBoxDisplyed() {
		return ((ProxyDriver) wd).isDisplayed(checkBox);
	}

	public String getMessageText() {

		return ((ProxyDriver) wd).getText(removedmessage);
	}

	public By getEnableButton() {
		return enableButton;
	}

	public void setEnableButton(By enableButton) {
		this.enableButton = enableButton;
	}

	public void ClickEnableButton() {
		((ProxyDriver) wd).click(enableButton);
	}

	public String getRemoveOrAddButtonText() {

		return ((ProxyDriver) wd).getText(removeButton);
	}

	public String getEnableButtonText() {

		return ((ProxyDriver) wd).getText(enableButton);
	}

	public boolean isTestBoxEnabled() {
		return ((ProxyDriver) wd).isEnabled(textBox);
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