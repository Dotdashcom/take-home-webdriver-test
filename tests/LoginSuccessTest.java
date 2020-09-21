package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObj.LoginSuccessPageObj;

public class LoginSuccessTest extends Base {
	LoginSuccessPageObj LogSuccessPageObj;

	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/login");
	}
	// Page Object Model for the login page should be provided.
	// Test is able to login successfully.
	// Test uses an assertion to make sure User has logged in.

	@Test
	public void loginWithSuccess() {
		LogSuccessPageObj = new LoginSuccessPageObj();
		LogSuccessPageObj.enterUserName(getUserName());
		LogSuccessPageObj.enterPassword(getPassword());
		LogSuccessPageObj.clickonLoginButton();

		String expectedMSG = "You logged into a secure area!";
		String actualMSG = driver.findElement(By.id("flash")).getText();

		Assert.assertEquals(actualMSG, expectedMSG);

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}
