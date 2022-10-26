package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.LoginPageObjects;

public class InvalidLoginTestCase extends BaseClass{

	@Test
	public void Failure_login() {
		LoginPageObjects logpage=new LoginPageObjects(driver);

		driver.get(url+"/login");
		
		logpage.Failed_login();
		logpage.returnedToLogin();
		Assert.assertEquals(logpage.Login_message.getText(), "Login Page");

	}
}
