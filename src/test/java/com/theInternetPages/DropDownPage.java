package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DropDownPage extends BasePage {

	WebDriver obj_Driver;
	String dropDownTitle = "//h3[text()='Dropdown List']";
	String dropdownList = "//select";

	public DropDownPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(dropDownTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(dropDownTitle)).size() > 0, "Drop down page is displayed");
	}

	public void dropDown() {
		dropDownSelect(dropdownList, "Option 1");
		isDisplayedAssert(dropdownList, "option 1 is displayed");
		dropDownSelect(dropdownList, "Option 2");
		isDisplayedAssert(dropdownList, "option 2 is displayed");
		
	}

}
