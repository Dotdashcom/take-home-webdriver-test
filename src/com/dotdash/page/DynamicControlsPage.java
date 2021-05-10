package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/dynamic_controls";
	private static final By CHECKBOX_LOCATOR = By.cssSelector("form[id='checkbox-example']>div>input");
	private static final By INPUTBOX_LOCATOR = By.cssSelector("form[id='input-example']>input");
	private WebElement checkbox;
	private WebElement checkboxToggleButton;
	private WebElement inputbox;
	private WebElement inputboxToggleButton;

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(true, false);
	}
	
	public void verifyPage(boolean expectedCheckbox, boolean expectingInputbox) {
		if (expectedCheckbox) {
			checkbox = driver.findElement(CHECKBOX_LOCATOR);
			assertTrue(checkbox.isDisplayed());
		} else {
			assertEquals(driver.findElements(CHECKBOX_LOCATOR).size(), 0);
		}

		checkboxToggleButton = driver.findElement(By.cssSelector("form[id='checkbox-example']>button"));
		assertTrue(checkboxToggleButton.isDisplayed());

		inputbox = driver.findElement(INPUTBOX_LOCATOR);
		assertTrue(inputbox.isDisplayed());
		assertEquals(inputbox.isEnabled(), expectingInputbox);

		inputboxToggleButton = driver.findElement(By.cssSelector("form[id='input-example']>button"));
		assertTrue(inputboxToggleButton.isDisplayed());
	}

	public void toggleCheckbox(boolean expectingToBeVisible) {
		checkboxToggleButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (expectingToBeVisible) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_LOCATOR));
		} else {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX_LOCATOR));
		}
	}

	public void toggleInputbox(boolean expectingToBeEnable) {
		inputboxToggleButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (expectingToBeEnable) {
			wait.until(ExpectedConditions.attributeToBe(INPUTBOX_LOCATOR, "disabled", ""));
		} else {
			wait.until(ExpectedConditions.attributeToBe(INPUTBOX_LOCATOR, "disabled", "true"));
		}
	}
}
