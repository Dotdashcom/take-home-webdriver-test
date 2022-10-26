package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class DynamicControlsPageObjects {

	WebDriver ldriver;
	
	public DynamicControlsPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//button[@onclick='swapCheckbox()']")
	public WebElement CheckBoxAddRemoveButton;
	
	@FindBy(xpath="//p[@id='message']")
	public WebElement checkboxmessage;
	
	@FindBy(xpath="//button[@onclick='swapInput()']")
	public WebElement TextBoxEnableDisableButton;
	
	
	
	
	
	
}
