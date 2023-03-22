package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class FloatingMenuPageElements extends CommonMethods {		
	
	@FindBy(id = "menu")
	public WebElement floatingMenuElement;	
	
	
	public FloatingMenuPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
