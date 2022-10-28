package com.internet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.internet.utils.Proxywrapper;

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
		((Proxywrapper) driver).click(removeOrAddButton);
	}

	public By getRemoveOrAddButton() {
		return removeOrAddButton;
	}

	public void setRemoveOrAddButton(By removeOrAddButton) {
		this.removeOrAddButton = removeOrAddButton;
	}

	public boolean isCheckBoxDisplyed() {
		return ((Proxywrapper) driver).isDisplayed(checkBox);
	}

	public String getMessageText(String value) {
		if (value.equals("Disappear")) {
			new WebDriverWait(driver, Duration.ofMillis(10000))
					.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
		} else {
			new WebDriverWait(driver, Duration.ofMillis(10000))
					.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		}
		return ((Proxywrapper) driver).getText(removedmessage);
	}

	public By getEnableButton() {
		return enableButton;
	}

	public void setEnableButton(By enableButton) {
		this.enableButton = enableButton;
	}

	public void ClickEnableButton() {
		((Proxywrapper) driver).click(enableButton);
	}

	public String getRemoveOrAddButtonText() {

		return ((Proxywrapper) driver).getText(removeOrAddButton);
	}

	public String getEnableButtonText() {

		return ((Proxywrapper) driver).getText(enableButton);
	}

	public boolean isTestBoxEnabled() {
		return ((Proxywrapper) driver).isEnabled(textBox);
	}
}
