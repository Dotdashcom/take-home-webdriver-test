package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class JavaScriptError extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public JavaScriptError(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locator for js error
	@FindBy (xpath = "//body[@onload='loadError()']")
	WebElement txtError;
	
	//method 
	public String JsError() {
		String ErrorText = bu.getMessageText(txtError, "Js Error message");
		return ErrorText;
	}
	
}
