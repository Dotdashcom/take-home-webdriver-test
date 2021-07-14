package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

	WebDriver obj_Driver;

	String loginTitle = "//h2[text()='Login Page']";
	String userName = ("//input[@name='username']");
	String pwd = ("//input[@name='password']");
	String loginButton = ("//button[@class='radius']");
	String loginSuccessMsg = ("//div[@class='flash success']");
	String loginFailMsg = ("//div[@class='flash error']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(loginTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(loginTitle)).size() > 0, "Login page is displayed");
	}

	public void enterUnameSuccess() {
		setValue(userName, "tomsmith", "user Name");
	}

	public void enterUnameFail() {
		setValue(userName, "admin", "user Name");
	}

	public void enterPwd() {
		setValue(pwd, "SuperSecretPassword!", "password");
	}

	public void clickLogin() {
		click(loginButton, "Login button");
	}

	public void isDisplayedLoginSuccessMsg() {
		isDisplayedAssert(loginSuccessMsg, "Login success message");
	}

	public void isDisplayedLoginFailMsg() {
		isDisplayedAssert(loginFailMsg, "Login Fail message");
	}
}
