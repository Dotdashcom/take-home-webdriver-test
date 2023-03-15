package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dotdash.testUtils.TestBase;

public class DropdownPOM extends TestBase {

	
	@FindBy(css="select#dropdown")
	WebElement drpdwn;
	
	@FindBy(css="select#dropdown>option:nth-of-type(2)")
	WebElement drpdwn1;
	
	@FindBy(css="select#dropdown>option:nth-of-type(3)")
	WebElement drpdwn2;
	
	public DropdownPOM() {
		PageFactory.initElements(driver,this);
	}
	
	public void selectOption1() {
		Select sel= new Select(drpdwn);
		sel.selectByVisibleText("Option 1");		
	}
	
	public void selectOption2() {
		Select sel= new Select(drpdwn);
		sel.selectByVisibleText("Option 2");	

	}
	
	public boolean isOption1Selected() {
        return drpdwn1.isSelected();
        
	}
	
	public boolean isOption2Selected() {
        return drpdwn2.isSelected();
        
	}
 
}
