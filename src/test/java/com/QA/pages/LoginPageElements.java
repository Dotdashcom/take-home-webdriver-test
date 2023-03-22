package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(className = "radius")
	public WebElement loginBtn;
	
	@FindBy(id = "flash")
	public WebElement flashMessage;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

}
