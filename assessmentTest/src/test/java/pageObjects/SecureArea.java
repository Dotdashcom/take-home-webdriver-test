package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class SecureArea extends baseutils {

	//call baseutils class
	baseutils bu = new baseutils();
		
		
	//create a constructor
	public SecureArea(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//get element locators for secure page message
	@FindBy (xpath = "//div[@id='flash']")
	WebElement messageLogin;
		
	//method to check if login is successfull
	public String LoginSuccessCheck() {
		
		//gets the page tiltle
		bu.getMessageText(messageLogin, "Secure Area");
		String msg = bu.messageToRetrieve(messageLogin, 30);
		return msg;
		
		/*String LoginSuccessPage = messageLogin.getText();
		System.out.println("Message displayed in Secure Area Page is : " + LoginSuccessPage);
		return 	LoginSuccessPage;*/
		
	}
}
