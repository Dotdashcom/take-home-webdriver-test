package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObj.LoginFailPageObj;

public class LoginFailureTest extends Base {

	LoginFailPageObj LoginFailObj;

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/login");
	}

//	Page Object Model for the login page should be used.
//	Test is not able to login with wrong credentials.
//	Test uses assertions to check Login failed for incorrect user and password.

	@Test
	public void loginWithSuccess() {
		LoginFailObj = new LoginFailPageObj();
		LoginFailObj.enterWrongUserName(getWrongUserName());
		LoginFailObj.enterWrongPassword(getWrongPassword());
		LoginFailObj.clickonLoginButton();

		String expectedMSG = "Your password is invalid!";
		String actualMSG = driver.findElement(By.className("flash error")).getText();
		Assert.assertEquals(actualMSG, expectedMSG);

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}
