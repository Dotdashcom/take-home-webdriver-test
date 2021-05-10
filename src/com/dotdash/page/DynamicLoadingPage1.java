package com.dotdash.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage1 extends AbstractPage {
	public static final String RELATIVE_PATH = "/dynamic_loading/1";
	protected static final By START_BUTTON_LOCATOR = By.cssSelector("div[id='start']>button");
	protected static final By DYNAMIC_TEXT_LOCATOR = By.id("finish");
	protected WebElement startButton;
	protected WebElement dynamicText;

	public DynamicLoadingPage1(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(true, false);
	}
	
	public void verifyPage(boolean expectingStartButton, boolean expectingDynamicText) {
		startButton = driver.findElement(START_BUTTON_LOCATOR);
		assertEquals(startButton.isDisplayed(), expectingStartButton);

		dynamicText = driver.findElement(DYNAMIC_TEXT_LOCATOR);
		assertEquals(dynamicText.isDisplayed(), expectingDynamicText);
	}

	public void loadDynamicText() {
		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DYNAMIC_TEXT_LOCATOR));
	}
}
