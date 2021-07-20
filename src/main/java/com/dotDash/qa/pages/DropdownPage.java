package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dotDash.qa.base.TestBase;

public class DropdownPage extends TestBase{
	//Instantiating  action class
	Actions actions = new Actions(driver);
	
	//Finding the link to the context Menu page
	@FindBy(xpath= "//a[@href='/dropdown']")  
	WebElement dropDown;
	
	//Finding Context Menu
	@FindBy(id ="dropdown") 
	WebElement dropDownELement;
	
	//Initializing the Page Objects:
	public DropdownPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public String dropDownOption1(){
		dropDown.click();
		Select dropdownElement = new Select(dropDownELement);  
		dropdownElement.selectByVisibleText("Option 1");
		String opt1 = dropdownElement.getFirstSelectedOption().getText();
		return opt1;
	}
	
	
	public String dropDownOption2(){
		dropDown.click();
		Select dropdownElement = new Select(dropDownELement);  
		dropdownElement.selectByVisibleText("Option 2"); 
		String opt2 = dropdownElement.getFirstSelectedOption().getText();
		return opt2;
	}
}
