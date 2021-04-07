package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class CheckBoxesPage extends BaseClass {

	// The following Initialization of the Page factory

	public CheckBoxesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'Checkboxes')]")
	@CacheLookup
	WebElement ClickCheckboxe;
	
	@FindBy(xpath = "//input[@type='checkbox'][1]")
	@CacheLookup
	WebElement UnChecked;

	@FindBy(xpath = "//input[@type='checkbox'][2]")
	@CacheLookup
	WebElement Checked;
	
	

	// The following are the Utilization by creating methods for each of the
	// components.

    //get URL
	public void getUrl() {
		driver.get(Base_URL);
		ClickCheckboxe.click();
	}

	// Method for UnChecked box
	public boolean UnCheckedBox() {
		if(!UnChecked.isSelected()){
			System.out.println(UnChecked.isSelected());
		}
		return false;

	}

	// Method for Checked box
	public boolean checkedBox() {
		if(Checked.isSelected()) {
			System.out.println(Checked.isSelected());
		}
		return true;

	}

}
