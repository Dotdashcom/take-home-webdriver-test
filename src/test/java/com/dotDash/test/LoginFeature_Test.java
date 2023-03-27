package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.LoginPage;
import com.dotDash.page.common.PageinstancesFactory;
import com.dotDash.utils.TestProperties;
import org.testng.annotations.Test;

public class LoginFeature_Test extends BaseTest{
	LoginPage login;
	@Test(description = "Test to Validate Successful login Scenario with valid credentials")
	void validLogin(){
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword"));
		login.checkLoginSuccessLabelExist();
	}

	@Test(description = "Test to Validate that after logout page not taking to Home page")
	void validLogout() {
		login.logout();
	}

	@Test(description = "Test to Validate UnSuccessful login Scenario with Invalid credentials")
	void invalidLogin(){
		loginFunc(TestProperties.getProperty("UserName_Incorrect"), TestProperties.getProperty("UserPassword"));
		login.checkLoginFailureLabelExist("USERNAME");
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword_Incorrect"));
		login.checkLoginFailureLabelExist("PASSWORD");
	}

	private void loginFunc(String sUserName,String sPassword) {
		login=PageinstancesFactory.getInstance(LoginPage.class);
		login.login(sUserName,sPassword);
	}
}