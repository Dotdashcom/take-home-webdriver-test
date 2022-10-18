package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_015_JavaScriptError_POM extends WT_BaseClass{
 
	//Locator
	@FindBy(xpath= "//p[contains(text(),'This page has a JavaScript error in the onload eve')]")
	WebElement Errormessage;
	
	//Constructor
	public WT_015_JavaScriptError_POM() {
	
	     PageFactory.initElements(driver,this );
    } 
	
	public WebElement ErrorMessage() {
		 Errormessage.isDisplayed();
		return Errormessage;
	}
	
}
	
