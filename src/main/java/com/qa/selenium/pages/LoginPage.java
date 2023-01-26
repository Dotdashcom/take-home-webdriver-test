package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Repo
	
	@FindBy(id = "username")
	WebElement username;

	@FindBy (id = "password")
	WebElement password;

	@FindBy (xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy (xpath = "//div[@id='flash-messages']/div")
	WebElement loginMessage;

	
	//Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void loginSuccessfull() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
	}

	public String readLoginMessage() {
		String pass = loginMessage.getText();
		return pass.substring(0, pass.length()-2);
	}

	public void loginFailure() {
		username.sendKeys(prop.getProperty("WrongUsername"));
		password.sendKeys(prop.getProperty("WrongPassword"));
		loginBtn.click();
	}

	public String readLoginFailureMessage() {
		String fail = loginMessage.getText();
		return fail.substring(0, fail.length()-2);
	}

}
	
	


