package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Finding the user name text box
	@FindBy(name = "username")
	WebElement username;

	// Finding the password text box
	@FindBy(name = "password")
	WebElement password;

	// Finding the login button
	@FindBy(className = "radius")
	WebElement loginBtn;

	// Finding the link to the login page
	@FindBy(xpath = "//a[@href='/login']")
	WebElement login;

	// FInding logout button
	@FindBy(xpath = "/html/body/div[2]/div/div/a")
	WebElement logoutBtn;

	// Finding the notification element on login page
	@FindBy(css = "#flash")
	WebElement notification;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Login test function
	public void login(String un, String pwd) {
		login.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

	}

	// login success test function
	public String sucess() {
		String success = notification.getText();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logoutBtn.click();
		return success;
	}

	// Login fail test function
	public String fail() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String fail = notification.getText();
		return fail;
	}

}
