package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Base;

public class DropdownPage extends Base{
	
	
	@FindBy(xpath="//select[@id='dropdown']")
	WebElement dropdownBtn ;

	
	
	public DropdownPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDropdownMenu() {
		dropdownBtn.click();
	}
	public void selectOption1FromDropdown() {
		Select select= new Select(dropdownBtn);
		select.selectByVisibleText("Option 1");
	}
	public void selectOption2FromDropdown() {
		Select select= new Select(dropdownBtn);
		select.selectByVisibleText("Option 2");
	}
	public String getTheSelectedOption() {
		Select select= new Select(dropdownBtn);
		String selectedOption=select.getFirstSelectedOption().getText();
		return selectedOption;
	}

}
