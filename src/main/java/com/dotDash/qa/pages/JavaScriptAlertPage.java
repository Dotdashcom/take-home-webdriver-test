package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.beust.jcommander.internal.Console;
import com.dotDash.qa.base.TestBase;

public class JavaScriptAlertPage extends TestBase {

	// Instantiating action class
	Actions actions = new Actions(driver);

	// Finding the link to the JavaScript Alert page
	@FindBy(xpath = "//a[@href='/javascript_alerts']")
	WebElement javaScriptAlert;

	// Finding JavaScript Alert Button
	@FindBy(xpath = "//button[@onclick=\"jsAlert()\"]")
	WebElement javaAlert;

	// Finding JavaScript conform Button
	@FindBy(xpath = "//button[@onclick=\"jsConfirm()\"]")
	WebElement javaConfirm;

	// Finding JavaScript prompt Button
	@FindBy(xpath = "//button[@onclick=\"jsPrompt()\"]")
	WebElement javaPrompt;

	// Finding the result tag
	@FindBy(id = "result")
	WebElement resultDisp;

	// Initializing the Page Objects:
	public JavaScriptAlertPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Alert pop-up test function
	public String alertJava() {
		javaScriptAlert.click();
		javaAlert.click();
		String alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alert;
	}

	// Confirm pop-up test function
	public String confirmJava() {
		javaScriptAlert.click();
		javaConfirm.click();
		String confirm = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return confirm;
	}

	// Prompt pop-up test function
	public String promptJava() {
		javaScriptAlert.click();
		javaPrompt.click();
		driver.switchTo().alert().sendKeys("Hello_World");
		driver.switchTo().alert().accept();
		String prompt = resultDisp.getText();
		return prompt;
	}
}
