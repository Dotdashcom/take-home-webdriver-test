package com.dotdashcom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

	WebDriver driver;
	
	public Login (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userField;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement btn;
	
	@FindBy(xpath="//div[contains(text(),'username is invalid')]")
	private WebElement loginError;
	
	public void enterUsername(String uname) {
		userField.sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void submitForm() {
		btn.click();
	}
	
	public String getErrorMsg() {
		return loginError.getText();
	}
}
