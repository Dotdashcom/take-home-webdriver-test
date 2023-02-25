package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class LoginPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//get element locators for login
	@FindBy (id = "username")
	WebElement txtUserName;
	
	@FindBy (id = "password")
	WebElement txtPassword;
	
	@FindBy (xpath = "//button[@type = 'submit']")
	WebElement btnSubmit;
	
	@FindBy (xpath = "//div[@class='flash error']")
	WebElement failLoginMsg;
	
	//methods for login 
	public void Login(String username, String password) {
		
		bu.EnterInInputField(txtUserName, username, "Username");
		bu.EnterInInputField(txtPassword, password, "Password");
		bu.clickOnElement(btnSubmit, "Submit");
		
	}
	
	public String LoginFail() {
		bu.getMessageText(failLoginMsg, "Login Failure message");
		String msg = bu.messageToRetrieve(failLoginMsg, 25);
		return msg;
		
		/*String message = failMsg.substring(0,25);
		System.out.println("failure message displayed is : " + message);
		return message;*/
	}
	
}
