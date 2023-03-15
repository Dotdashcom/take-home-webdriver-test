package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class LoginPOM extends TestBase {
	
	@FindBy(css="input#username")
	WebElement username;
	
	@FindBy(css="input#password")
	WebElement password;
	
	@FindBy(css="i.fa-sign-in")
	WebElement login;
	
//	@FindBy(css="h4.subheader")
//	WebElement loginSuccessText;

	
	@FindBy(css="div#flash")
	WebElement loginText;
	
public LoginPOM() {
	PageFactory.initElements(driver,this);
}	

public void login(String uname,String pword) {
	System.out.println("*****"+username+"******");
	username.sendKeys(uname);
	password.sendKeys(pword);
	//username.sendKeys(username);
	//password.sendKeys(prop.getProperty("password"));

}

public void clickLoginButton() {
	login.click();

}

public String checkLoginText() {
	String loginSuccess=loginText.getText();	
	return loginSuccess;
}
}
