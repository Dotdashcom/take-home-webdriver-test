package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class DynamicLoadingPageElements extends CommonMethods {		
	
	@FindBy(xpath = "//button[contains(text(),'Start')]")
	public WebElement startBtn;		
	
	@FindBy(id = "finish")
	public WebElement message;	
	
	public DynamicLoadingPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
