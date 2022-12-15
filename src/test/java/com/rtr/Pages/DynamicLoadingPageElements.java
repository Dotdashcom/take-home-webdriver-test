package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class DynamicLoadingPageElements extends CommonMethods{

	@FindBy (css = "#start > button")
	public WebElement startBttn;
	
	@FindBy (id = "finish")
	public WebElement hwmsg;

	
	public DynamicLoadingPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
