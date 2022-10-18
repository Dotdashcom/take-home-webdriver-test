package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import webtests.BasePackage.WT_BaseClass;

public class WT_005_Dropdown_POM extends WT_BaseClass {

	//Locator
	@FindBy (xpath= "//select[@id='dropdown']")
	WebElement Dropdownlist;
	
	//Constructor
	public WT_005_Dropdown_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public String Dropdown1() {
		Dropdownlist.click();
		Select select = new Select(Dropdownlist) ;
	
	    select.selectByIndex(1); 
	    return select.getFirstSelectedOption().getText();      
	   
	}
	
	public String Dropdown2() {
		Dropdownlist.click();
		Select select = new Select(Dropdownlist) ;
		
	    select.selectByVisibleText("Option 2");
	    return select.getFirstSelectedOption().getText();
	
	}
	
	
}
