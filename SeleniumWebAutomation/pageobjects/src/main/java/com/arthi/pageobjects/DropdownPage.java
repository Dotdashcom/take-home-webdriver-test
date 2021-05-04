package com.arthi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class DropdownPage extends PageBase {
	
	private static final String Base_URL = "http://localhost:7080/dropdown";
		
	@FindBy(id="dropdown")
	private WebElement element;
	
	
	public DropdownPage(WebDriver driver) {		
		super(driver);	
	}
	
	public DropdownPage navigateToDropDownPage() {
		driver.get(Base_URL);
		return this;	
	}
	
	public DropdownPage selectValueFromDropDown(String value) {
		Select select =  new Select(element);
		//setSelectOptionBasedOnDisplayText(element, value);
		select.selectByVisibleText(value);
		return this;
		
	}
	

}
