package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPageElements extends BaseClass{

	//Click For JS Alert button location
	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	public WebElement clickJSAlert;
	
	//Click For JS Confirm button location
	@FindBy(xpath = "//button[@onclick='jsConfirm()']")
	public WebElement clickJSConfirm;
	
	//Click For JS Prompt button location
	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	public WebElement clickJSPrompt;
	
	public JavaScriptAlertsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
