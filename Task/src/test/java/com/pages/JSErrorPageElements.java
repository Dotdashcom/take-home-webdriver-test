package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPageElements extends BaseClass{
	
	//Error Message location
	@FindBy(xpath = "//body[@onload='loadError()']/p")
	public WebElement errorMessage;
	
	public JSErrorPageElements() {
		PageFactory.initElements(driver, this);
	}

}
