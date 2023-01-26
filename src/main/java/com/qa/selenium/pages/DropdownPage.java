package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class DropdownPage extends TestBase{
	
	@FindBy (id = "dropdown")
	WebElement optionTab;
	
	@FindBy (css = "option[value='1']")
	WebElement option1;
	
	@FindBy (css = "option[value='2']")
	WebElement option2;
	
	@FindBy (css = "option[selected='selected'][value='1']")
	WebElement option1isSelected;
	
	@FindBy (css = "option[selected='selected'][value='2']")
	WebElement option2isSelected;
	
	
	
	
	public DropdownPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void menu() {
		optionTab.click();
	}
	
	public void selectOption1() {
		option1.click();
	}
	
	public void selectOption2() {
		option2.click();
	}
	public boolean selected1() {
		return option1isSelected.isDisplayed();
	}

	public boolean selected2() {
		return option2isSelected.isDisplayed();
	}
}
