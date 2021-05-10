package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternalFramePage extends AbstractPage {
	public static final String RELATIVE_PATH = "/iframe";
	private WebElement iframe;

	public InternalFramePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		iframe = driver.findElement(By.id("mce_0_ifr"));
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
