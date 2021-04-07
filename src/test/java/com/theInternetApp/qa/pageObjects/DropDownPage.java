package com.theInternetApp.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class DropDownPage extends BaseClass {

	// The following Initialization of the Page factory
	public DropDownPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'Dropdown')]")
	@CacheLookup
	WebElement DropDownLink;

	@FindBy(id = "dropdown")
	@CacheLookup
	WebElement DropDown;

	// The following are the Utilizations by creating methods for each of the
	// components.

	// get URL
	public void getUrl() {
		driver.get(Base_URL);
		DropDownLink.click();
	}

	// Drop Down list
	public void dropDown() {
		String arr[] = { "Please select an option", "Option 1", "Option 2" };
		Select select = new Select(DropDown);
		List<WebElement> dropDownValues = select.getOptions();

		for (int i = 0; i < dropDownValues.size(); i++) {
			Assert.assertEquals(arr[i], dropDownValues.get(i).getText());
		}

	}

}
