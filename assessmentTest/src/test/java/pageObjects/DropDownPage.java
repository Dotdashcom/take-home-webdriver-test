package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseClass.baseutils;

public class DropDownPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
		
	//create a constructor
	public DropDownPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for dropdown
	@FindBy (xpath = "//select[@id='dropdown']")
	WebElement dropdownOptions;
	
	//methods to select from dropdown
	public String handlingDropdown(String dropdownName) {
		Select select = new Select(dropdownOptions);
		System.out.println("Please select an option : Option 1 / Option 2");
		select.selectByVisibleText(dropdownName);
		System.out.println("Selected option is : " +dropdownName);
		return dropdownName;
	}
	

}
