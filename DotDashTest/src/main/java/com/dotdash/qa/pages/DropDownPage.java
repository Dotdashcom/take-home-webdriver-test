package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dotdash.qa.base.TestBase;

public class DropDownPage extends TestBase{
	
	@FindBy(xpath="//select[@id='dropdown']")
	WebElement dropDown; 
	
	public DropDownPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectValue() {
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Option 2");
	}

}
