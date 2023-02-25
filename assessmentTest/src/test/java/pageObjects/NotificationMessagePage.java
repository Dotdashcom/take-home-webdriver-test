package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class NotificationMessagePage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public NotificationMessagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locator for clickhere
	@FindBy (linkText = "Click here")
	WebElement lnkClick;
	
	//locator for flash message
	@FindBy (xpath = "//div[@id='flash']")
	WebElement txtFlash;
	
	//methods 
	public void HandlingNotificationMessage() {
		boolean status =  true;
		for(int i=0;i<5;i++) {
			bu.clickOnElement(lnkClick, "Click here link");
			String msg = bu.getMessageText(txtFlash, "Flash message");
			System.out.println("flash message dispplayed is : "+msg );
		}
	}
}

