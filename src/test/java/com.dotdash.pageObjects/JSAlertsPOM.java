package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class JSAlertsPOM extends TestBase {

	@FindBy(css="div.example>ul>li:nth-of-type(1)>button")
	WebElement jsAlert;
	
	@FindBy(css="div.example>ul>li:nth-of-type(2)>button")
	WebElement jsConfirm;
	
	@FindBy(css="div.example>ul>li:nth-of-type(3)>button")
	WebElement jsPromt;

	@FindBy(css="p#result")
	WebElement jsPromtText;
	
	
	
	public JSAlertsPOM() {
		PageFactory.initElements(driver,this);
	}	

	public void switchToJSAlert() {
		jsAlert.click();

	}
	public String JSAlertText() {
		String JSText=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return JSText;
	}
	
	public void switchToJSConfirm() {
		jsConfirm.click();
	}
	
	public void switchToJSPrompt() {
		jsPromt.click();
	}
	
	public String JSPromptText() {
		driver.switchTo().alert().sendKeys(prop.getProperty("JSPromtEnterText"));
		driver.switchTo().alert().accept();
		String JsText=jsPromtText.getText();
		return JsText;
		
	
	}
}
