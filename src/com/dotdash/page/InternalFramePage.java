package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternalFramePage extends AbstractPage {
	public static final String RELATIVE_PATH = "/iframe";
	private static final By IFRAME_LOCATOR = By.id("mce_0_ifr");
	private WebElement iframe;

	public InternalFramePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(IFRAME_LOCATOR));
		iframe = driver.findElement(IFRAME_LOCATOR);
		assertTrue(iframe.isDisplayed());
	}
	
	public void verifyEditorText(String expectedText) {
		driver.switchTo().frame("mce_0_ifr");
		WebElement editor = driver.findElement(By.id("tinymce"));
		assertTrue(editor.getText().contains(expectedText));
		driver.switchTo().defaultContent();
	}

	public void typeOnEditor(String text) {
		driver.switchTo().frame("mce_0_ifr");
		WebElement editor = driver.findElement(By.id("tinymce"));
		editor.sendKeys(text);
		driver.switchTo().defaultContent();
	}
}
