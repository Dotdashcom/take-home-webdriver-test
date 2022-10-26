package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPageObjects {

	WebDriver ldriver;
	public JavaScriptAlertsPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//li/button[@onclick='jsAlert()']")
	private WebElement AlertButton1;
	
	@FindBy(xpath="//p[@id='result']")
	private WebElement Alertmsg;
	
	@FindBy(xpath="//li/button[@onclick='jsConfirm()']")
	private WebElement ConfirmAlertButton;
	
	@FindBy(xpath="//li/button[@onclick='jsPrompt()']")
	private WebElement PromptButton;
	
	public void ClickAlert() {
		AlertButton1.click();
		ldriver.switchTo().alert().accept();	
	}
	
	public void ClickConfirmAlert() {
		ConfirmAlertButton.click();
		ldriver.switchTo().alert().dismiss();
	}
	
	public void ClickPromptAlert() {
		PromptButton.click();
		Alert promptalert=ldriver.switchTo().alert();
		promptalert.sendKeys("text entered in the prompt box");
		promptalert.accept();
	}
	
	public String Resultmsg() {
		String resultmsg=Alertmsg.getText();
		return resultmsg;
	}
}
