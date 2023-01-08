package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownpage {
 WebDriver driver;
 
 @FindBy(id="dropdown")
 WebElement dropDown;
 
 public DropDownpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

public void VerifyDropDown()
{
Select Dropdown_list=new Select(dropDown);
Dropdown_list.selectByValue("1");
String option_text=Dropdown_list.getFirstSelectedOption().getText();
Assert.assertEquals(option_text,"Option 1"); //Comparing text text of selected option with the Expected
Dropdown_list.selectByVisibleText("Option 2");
String option_text2=Dropdown_list.getFirstSelectedOption().getText();
Assert.assertEquals(option_text2,"Option 2");
}
}