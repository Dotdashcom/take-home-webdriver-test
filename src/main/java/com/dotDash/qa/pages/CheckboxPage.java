package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class CheckboxPage extends TestBase {
	@FindBy(xpath ="//*[@id=\"checkboxes\"]/input[2]")
	WebElement checkbox2;
	
	@FindBy(xpath ="//*[@id=\"checkboxes\"]/input[1]")
	WebElement checkbox1;
	
	@FindBy(xpath= "//a[@href='/checkboxes']")  
	WebElement checkboxes;
	
	//Initializing the Page Objects:
	public CheckboxPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public String checkbox(){
		checkboxes.click();
		checkbox1.click();
		if(checkbox1.isSelected())
		{
			String checked  = "Checkbox 1 is selected";
			return checked;
		}
		else
		{
			String unchecked = "Checkbox 2 is not selected";
			return unchecked;
		}
	}
	
	public String checkbox2() {
		checkboxes.click();
		checkbox2.click();
		if(!checkbox2.isSelected())
		{
			String checked  = "Checkbox 2 is not selected";
			return checked;
		}
		else
		{
			String unchecked = "Checkbox 2 is selected";
			return unchecked;
		}
	}
}
