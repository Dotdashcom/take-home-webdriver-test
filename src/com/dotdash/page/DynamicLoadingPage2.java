package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage2 extends DynamicLoadingPage1 {
	public static final String RELATIVE_PATH = "/dynamic_loading/2";

	public DynamicLoadingPage2(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage(boolean expectingStartButton, boolean expectingDynamicText) {
		startButton = driver.findElement(START_BUTTON_LOCATOR);
		assertEquals(startButton.isDisplayed(), expectingStartButton);

		if (expectingDynamicText) {
			dynamicText = driver.findElement(DYNAMIC_TEXT_LOCATOR);
			assertTrue(dynamicText.isDisplayed());
		} else {
			assertEquals(driver.findElements(DYNAMIC_TEXT_LOCATOR).size(), 0);
		}
	}
}
