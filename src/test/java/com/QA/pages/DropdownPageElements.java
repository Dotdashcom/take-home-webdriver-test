package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class DropdownPageElements extends CommonMethods {		
	
	@FindBy(id = "dropdown")
	public WebElement dropdownDD;	
	
	public DropdownPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
