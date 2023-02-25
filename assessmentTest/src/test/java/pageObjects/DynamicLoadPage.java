package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class DynamicLoadPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public DynamicLoadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for start button
	@FindBy (xpath = "//div[@id='start']")
	WebElement btnStart;
	
	//locator for message
	@FindBy (xpath = "//div[@id='finish']")
	WebElement txtMessage;
		
	//methods
	public String dynamicLoad() {
		bu.ElementToBeClickable(driver, btnStart);
		bu.moveToElement_click(driver, btnStart);
		bu.clickOnElement(btnStart, "start button");
		bu.waitForElement(driver, txtMessage);
		String msg = bu.getMessageText(txtMessage, "Message after clicking start");
		return msg;
	}
}
