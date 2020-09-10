package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends BaseClass {
	// login page username field location
	@FindBy(id = "username")
	public WebElement userName;

	// login page password field location
	@FindBy(id = "password")
	public WebElement password;

	// login page Login button lacation
	@FindBy(css = "button.radius")
	public WebElement loginBtn;

	// logout button location
	@FindBy(css = "i[class*='signout']")
	public WebElement logout;

	// error message location
	@FindBy(css = "div#flash")
	public WebElement errorMsg;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

}
