package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.util.PageLinks;

public class JsAlertsPage extends BasePage{

	public JsAlertsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li/button[text()='Click for JS Alert']")
	private WebElement btnJsAlert;
	
	@FindBy(xpath = "//li/button[text()='Click for JS Confirm']")
	private WebElement btnJsConfirm;
	
	@FindBy(xpath = "//li/button[text()='Click for JS Prompt']")
	private WebElement btnJsPrompt;
	
	@FindBy(id = "result")
	private WebElement result;
	
	public void visitJsAlerstPage() {
		getDriver().get(PageLinks.JS_ALERTS_PAGE);
	}
	
	public void verifyJsAlerts() throws InterruptedException {
		WebDriver driver = getDriver();
		btnJsAlert.click();
		
		Alert jsAlert = driver.switchTo().alert();
		assertEquals("I am a JS Alert", jsAlert.getText().trim());
		jsAlert.accept();
		assertEquals("You successfuly clicked an alert", result.getText().trim());
		Thread.sleep(1000);
		
		btnJsConfirm.click();
		Alert jsConfirm = driver.switchTo().alert();
		assertEquals("I am a JS Confirm", jsConfirm.getText().trim());
		jsConfirm.accept();
		assertEquals("You clicked: Ok", result.getText().trim());
		Thread.sleep(1000);
		
		btnJsPrompt.click();
		Alert jsPrompt = driver.switchTo().alert();
		jsPrompt.sendKeys("Hi there!");
		jsPrompt.accept();
		
		assertTrue(result.getText().contains("Hi there!"));
		Thread.sleep(1000);
	}
	
}
