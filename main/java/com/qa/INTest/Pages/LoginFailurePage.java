package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class LoginFailurePage extends TestBase {
	
	@FindBy(linkText = "Form Authentication")
	WebElement formLink;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement lgnBtn;

	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement logoutBtn;

	@FindBy(xpath = "//div[@id='flash']")
	WebElement err;

	public LoginFailurePage() {

		PageFactory.initElements(driver, this);

	}
	
	public void clickOnFormAuthentication() {
		formLink.click();
		
	}

	public String loginWithWrongCred(String un1, String pass1) {

		userName.sendKeys(un1);
		password.sendKeys(pass1);
		lgnBtn.click();
		
		return err.getText();

		
	}
}
