package com.test.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.Config;

public class DynamicControlsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By checkbox = By.cssSelector("#checkbox-example input[type='checkbox']");
	private By removeButton = By.cssSelector("#checkbox-example button");
	private By inputField = By.cssSelector("#input-example input[type='text']");
	private By toggleButton = By.cssSelector("#input-example button");
	private By message = By.id("message");
	private By loading = By.id("loading");

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		driver.get(Config.getUrl("dynamiccontrols"));
	}

	public void clickRemoveButton() {
		driver.findElement(removeButton).click();
		new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
	}

	public void clickAddButton() {
		driver.findElement(removeButton).click();
		new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
	}

	public void clickToggleButton() {
		driver.findElement(toggleButton).click();
		new WebDriverWait(driver, 10);
		if (isInputFieldEnabled()) {
			wait.until(ExpectedConditions.textToBe(message, "It's disabled!"));
		} else {
			wait.until(ExpectedConditions.textToBe(message, "It's enabled!"));
		}
	}

	public boolean isCheckboxDisplayed() {
		try {
			driver.findElement(checkbox);
			return true; // Checkbox is still present
		} catch (NoSuchElementException e) {
			return false; // Checkbox is gone
		}
	}

	public boolean isCheckboxEnabled() {
		return driver.findElement(checkbox).isEnabled();
	}

	public boolean isInputFieldEnabled() {
		return driver.findElement(inputField).isEnabled();
	}

	public void setInputFieldValue(String value) {
		driver.findElement(inputField).sendKeys(value);
	}

	public String getMessageText() {
		return driver.findElement(message).getText();
	}
}