package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownCheck {
	
	WebDriver driver;
	@FindBy(id="dropdown")
	WebElement dropdownlist;

	
	Select selectionList;

	public DropDownCheck(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "dropdown";
		driver.get(url);
		PageFactory.initElements(driver, this);
		selectionList = new Select(dropdownlist);
	}

	

	public WebElement getDropdownlist() {
		return dropdownlist;
	}

	
	public Select getSelectionList()
	{
		return selectionList;
	}
}
