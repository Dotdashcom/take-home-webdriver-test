package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class JavaScriptAlertsPage extends Base{
	
	@FindBy(xpath="//button[@onclick='jsAlert()']")
	WebElement jsAlert;
	@FindBy(xpath="//button[@onclick='jsConfirm()']")
	WebElement jsConfirm;
	@FindBy(xpath="//button[@onclick='jsPrompt()']")
	WebElement jsPrompt;
	@FindBy(xpath="//p[@id='result']")
	WebElement promptTypedMsg;
	
	public JavaScriptAlertsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnJsAlertBtn() {
		jsAlert.click();
	}
	
	public String getJsAlertMsg() {
		Alert alert=driver.switchTo().alert();
		String jsAlertMsg=alert.getText();
		return jsAlertMsg;
	}
	
	public void dismissJsAlert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();;
	}
	public void clickOnJsConfirmBtn() {
		jsConfirm.click();
	}
	public String getJsConfirmMsg() {
		Alert alert=driver.switchTo().alert();
		String jsConfirmMsg=alert.getText();
		return jsConfirmMsg;
	}
	
	public void acceptJsConfirm() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void clickOnJsPromptBtn() {
		jsPrompt.click();
	}
	public String getJsPromptMsg() {
		Alert alert=driver.switchTo().alert();
		String jsPromptMsg=alert.getText();
		return jsPromptMsg;
	}
	public void enterTheMsginPromptTextBox() {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("This is user typed the prompt message");;
	}
	
	public void acceptJsPrompt() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public String getTheUserTypedPromptText() {
		String msg=promptTypedMsg.getText();
		return msg;
	}

}
