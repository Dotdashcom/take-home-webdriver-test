package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPageElements extends BaseClass {
	
	//Remove/Add button location
	@FindBy(css = "button[onclick='swapCheckbox()']")
	public WebElement removeAddBtn;
	
	
	public DynamicControlsPageElements(){
		PageFactory.initElements(driver, this);
	}

}
