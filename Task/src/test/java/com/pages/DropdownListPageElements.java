package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownListPageElements extends BaseClass {

	//dropDown element location
	@FindBy(xpath = "//select[@id='dropdown']")
	public WebElement dropDown;
	
	public DropdownListPageElements() {
		PageFactory.initElements(driver, this);
	}
}
