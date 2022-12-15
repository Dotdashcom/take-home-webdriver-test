package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {
	
	@FindBy (id = "username")
	public WebElement username;
	
	@FindBy (id = "password")
	public WebElement password;
	
	@FindBy (css = "button[type=submit]")
	public WebElement loginBtn;
	
	@FindBy (id = "flash")
	public WebElement InvalidMsg;
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	

}
