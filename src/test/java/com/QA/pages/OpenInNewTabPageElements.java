package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class OpenInNewTabPageElements extends CommonMethods {			
		
	@FindBy(xpath = "//a[normalize-space()='Click Here']")
	public WebElement clickHereLink;	
	
	public OpenInNewTabPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
