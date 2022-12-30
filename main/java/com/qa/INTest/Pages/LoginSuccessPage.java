package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class LoginSuccessPage extends TestBase {
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

	public LoginSuccessPage() {

		PageFactory.initElements(driver, this);

	}
	
	public void clickOnFormAuthentication() {
		formLink.click();
		
	}

	public boolean loginWithCorrectCred(String un, String pass) {

		userName.sendKeys(un);
		password.sendKeys(pass);
		lgnBtn.click();

		return logoutBtn.isDisplayed();
	}

}
