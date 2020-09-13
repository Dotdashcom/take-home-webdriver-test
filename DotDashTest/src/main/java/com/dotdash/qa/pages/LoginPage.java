package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'flash success')]")
	WebElement successMsg;
	
	@FindBy(xpath="//div[contains(@class,'flash error')]")  
	WebElement failureMsg;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	public boolean validateSuccessMsg() {
		return successMsg.isDisplayed();
	}
	
	public boolean validateFailureMsg() {
		return failureMsg.isDisplayed();
	}
	
}
