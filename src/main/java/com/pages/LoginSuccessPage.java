package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginSuccessPage extends TestBase {
	
	@FindBy(xpath="//i[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//h4[contains(text(),'Welcome to the Secure Area')]")
	WebElement welcomeText;
	
	public LoginSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateWelcomeMessagePresent() {
		return welcomeText.getText();
	}

	public boolean validateTheLogoutButtonIsDisplayed() {
		return logoutBtn.isDisplayed();
	}
	
	public LoginPage clickOnLogoutButton() {
		logoutBtn.click();
		return new LoginPage();
	}
	

}
