package com.theInternetApp.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class LoginPage extends BaseClass {

	//The following Initialization of the Page factory  
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 
	}

	//The following are Declaration the web elements
	
	@FindBy(id = "username")
	@CacheLookup
	WebElement textUserName;

	@FindBy(id = "password")
	@CacheLookup
	WebElement textPassword;

	@FindBy(xpath = "//i[contains(text(),'Login')]")
	@CacheLookup
	WebElement LogInButton;

	@FindBy(xpath = "//div[@id='flash']")
	@CacheLookup
	WebElement FlashText;
	
	
	
	//The following are the Utilization by creating methods for each of the components.

	//get URL
	public void getUrl() {
		driver.get(Base_URL+ login_path);
	}
	//set User Name
	public void setUserName(String un) {
		textUserName.clear();
		textUserName.sendKeys(un);
	}

	//set User Pasword
	public void setUserPasword(String pwd) {
		textPassword.clear();
		textPassword.sendKeys(pwd);
	}

	//click on LogIn
	public void clickLogIn() {
		LogInButton.click();
	}

	//get flash messages
		public String getTextFlash() {
			return FlashText.getText();
		}
	
	
}








