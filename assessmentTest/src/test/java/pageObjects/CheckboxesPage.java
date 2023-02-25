package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class CheckboxesPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public CheckboxesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for checkbox 1
	@FindBy (xpath = "(//input[@type ='checkbox'])[1]")
	WebElement btnCheckbox1;
	
	//locators for checkbox 1
	@FindBy (xpath = "(//input[@type ='checkbox'])[2]")
	WebElement btnCheckbox2;
	
	//methods for checkbox
	public boolean HandlingCheckbox1(String checkboxName) {
		boolean status = bu.handlingCheckbox(btnCheckbox1, "checkbox 1");
		return status;
	}
	
	public boolean HandlingCheckbox2(String checkboxName) {
		boolean status = bu.handlingCheckbox(btnCheckbox2, "checkbox 2");
		return status;
	}
		
			
			
		
}

	

