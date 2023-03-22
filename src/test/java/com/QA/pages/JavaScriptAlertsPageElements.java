package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class JavaScriptAlertsPageElements extends CommonMethods {			
	
	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	public WebElement jsAlertBtn;
	
	@FindBy(xpath = "//button[@onclick='jsConfirm()']")
	public WebElement jsConfirmBtn;
	
	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	public WebElement jsPromptBtn;
	
	@FindBy(xpath = "//p[@id='result']")
	public WebElement resultMessage;
		
	public JavaScriptAlertsPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
