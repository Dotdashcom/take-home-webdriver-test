package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class DynamicControlPage extends baseutils{

	/*
	1. Test clicks on the Remove Button and uses explicit wait.
	Test asserts that the checkbox is gone.
	2. Test clicks on Add Button and uses explicit wait.
	Test asserts that the checkbox is present.
	3. Test clicks on the Enable Button and uses explicit wait.
	Test asserts that the text box is enabled.
	4.Test clicks on the Disable Button and uses explicit wait.
	Test asserts that the text box is disabled.*/
	

	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public DynamicControlPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for add/remove button
	@FindBy (xpath = "(//button[@type='button'])[1]")
	WebElement btnAddRemove;
	
	//locator for message in add/remove
	@FindBy (xpath = "//p[@id='message']")
	WebElement msgAddRemove;
	
	//locator for checkbox
	@FindBy (id ="checkbox")
	WebElement chkbox;
	
	//locators for enable/disable
	@FindBy (xpath = "(//button[@type='button'])[2]")
	WebElement btnEnableDisable;
	
	//locators for textField
	@FindBy (xpath = "//input[@type='text']")
	WebElement txtField;
	
	//methods for add/remove
	public String DynamicControlRemove() {
		bu.ElementDisplayed(chkbox, "checkbox");
		bu.clickOnElement(btnAddRemove, "Remove button");
		bu.waitForElement(driver, msgAddRemove);
		String AfterClicking = bu.getMessageText(msgAddRemove, "Remove/Add button");
		return AfterClicking;
	}
	
	//method for add
	public String DynamicControlAdd() {
		bu.clickOnElement(btnAddRemove, "Add button");
		bu.waitForElement(driver, msgAddRemove);
		bu.ElementDisplayed(chkbox, "checkbox");
		String AfterClicking = bu.getMessageText(msgAddRemove, "Remove/Add button");
		return AfterClicking;
	}
	
	//method for enable
	public String DynamicControlEnable() {
		bu.clickOnElement(btnEnableDisable, "Enable button");
		bu.waitForElement(driver, msgAddRemove);
		bu.elementEnabled(txtField, "Enable");
		String AfterClicking = bu.getMessageText(msgAddRemove, "Remove/Add button");
		return AfterClicking;
	}
	
	//method for disable

	//method for enable
	public String DynamicControldisable() {
		bu.clickOnElement(btnEnableDisable, "Disable button");
		bu.waitForElement(driver, msgAddRemove);
		bu.elementEnabled(txtField, "Disable");
		String AfterClicking = bu.getMessageText(msgAddRemove, "Remove/Add button");
		return AfterClicking;
	}
}
