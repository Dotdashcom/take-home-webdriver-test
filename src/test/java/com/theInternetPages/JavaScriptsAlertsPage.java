package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class JavaScriptsAlertsPage extends BasePage {

	WebDriver obj_Driver;
	String title = "//h3[text()='JavaScript Alerts']";
	String jsAlert = "//button[text()='Click for JS Alert']";
	String alertMessage = "//p[contains(text(),'You successfuly clicked an alert')]";
	String jsConfirm = "//button[@onclick='jsConfirm()']";
	String confirmMessage = "//p[contains(text(),'You clicked: Ok')]";
	String jsPrompt = "//button[@onclick='jsPrompt()']";
	String promptMessage = "//p[contains(text(),'TEXT')]";
	String jsPromptMsg = "Hello JS Prompt";

	public JavaScriptsAlertsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(title);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(title)).size() > 0, "JS Alerts page is displayed");
	}

	public void clickJsAlert() {
		click(jsAlert, "JS Alert");
	}

	public void jsAlertAccept() {
		alertAcceptWithVerifyText("I am a JS Alert");
	}

	public void clickJsConfirm() {
		click(jsConfirm, "JS Confirm");
	}

	public void JsConfirmAccept() {
		alertAcceptWithVerifyText("I am a JS Confirm");
	}

	public void clickJsPrompt() {
		click(jsPrompt, "JS Prompt");
	}

	public void setPromptValue() {
		setAlertText(jsPromptMsg);
		alertAccept();
	}

	public void verifyText() {
		isDisplayedAssert(promptMessage.replace("TEXT", jsPromptMsg), "Prompt Result message");
	}

}
