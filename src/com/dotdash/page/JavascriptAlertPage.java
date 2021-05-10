package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptAlertPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/javascript_alerts";
	private WebElement jsAlertButton;
	private WebElement jsConfirmButton;
	private WebElement jsPromptButton;
	private WebElement result;

	public JavascriptAlertPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		jsAlertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
		assertTrue(jsAlertButton.isDisplayed());

		jsConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
		assertTrue(jsConfirmButton.isDisplayed());

		jsPromptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
		assertTrue(jsPromptButton.isDisplayed());

		result = driver.findElement(By.id("result"));
		assertTrue(jsPromptButton.isDisplayed());
	}
	
	public void clickAndVerifyAlert() {
		jsAlertButton.click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		
		assertEquals(result.getText(), "You successfuly clicked an alert");
	}
	
	public void clickAndVerifyConfirmation(boolean accept) {
		jsConfirmButton.click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "I am a JS Confirm");
		if (accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		
		String expectedText = accept ? "You clicked: Ok" : "You clicked: Cancel";
		assertEquals(result.getText(), expectedText);
	}

	public void clickAndVerifyPrompt(String text) {
		jsPromptButton.click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys(text);
		alert.accept();
		
		assertEquals(result.getText(), "You entered: " + text);
	}
}
