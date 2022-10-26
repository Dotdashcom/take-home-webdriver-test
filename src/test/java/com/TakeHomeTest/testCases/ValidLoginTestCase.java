package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.LoginPageObjects;

public class ValidLoginTestCase extends BaseClass{
	
	

	@Test
	public void success_logintest() {
		LoginPageObjects logpage=new LoginPageObjects(driver);

		driver.get(url+"/login");
		logpage.Enter_username();
		logpage.Enter_password();
		logpage.Press_Login();
		logpage.Success_login_msg();
		Assert.assertEquals(logpage.Login_message.getText(), "Secure Area");
		logpage.Click_Logout();
	}
	
	
}
