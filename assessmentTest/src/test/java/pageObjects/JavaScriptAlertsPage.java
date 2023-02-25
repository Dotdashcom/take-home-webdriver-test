package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class JavaScriptAlertsPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public JavaScriptAlertsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for JsAlert
	@FindBy (xpath = "//button[@onclick='jsAlert()']")
	WebElement btnjsAlert;
	
	//locators for JsAlert
	@FindBy (xpath = "//button[@onclick='jsConfirm()']")
	WebElement btnjsConfirm;
		
	//locators for JsAlert
	@FindBy (xpath = "//button[@onclick='jsPrompt()']")
	WebElement btnjsPrompt;
	
	//methods to handle alert
	public String JsAlert() {
		bu.clickOnElement(btnjsAlert, "JS Alert button");
		String textInAlert = bu.HandlingAlert(driver, btnjsAlert, "JS Alert");
		bu.AcceptAlert(driver);
		return textInAlert;
	
	}
	
	public String JsConfirm() {
		bu.clickOnElement(btnjsConfirm, "JS confirm button");
		String TextinConfirm = bu.HandlingAlert(driver, btnjsConfirm, "JS confirm button");
		bu.AcceptAlert(driver);
		return TextinConfirm;
	}
	
	public String JsPromt() {
		bu.clickOnElement(btnjsPrompt, "JS Prompt button");
		String AlertMessage = bu.HandlingAlert(driver, btnjsPrompt, "JS Prompt button");
		String TextTyped = bu.EnterInalert(driver, "HI! This is the text in alert");
		bu.AcceptAlert(driver);
		return TextTyped;
	}
}
