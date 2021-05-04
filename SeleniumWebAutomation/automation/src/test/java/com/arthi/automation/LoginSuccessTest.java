package com.arthi.automation;


import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.LoginSuccessPage;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class LoginSuccessTest extends TestBase {

	@Test(priority=0, description=" verify the login test with valid username and password")
	public void valid_Username_Password_Test() {
		LoginSuccessPage loginsuccesspage = new LoginSuccessPage(getDriver());
		loginsuccesspage.navigateToLoginSuccessPage()
		.loginToSecureArea("tomsmith", "SuperSecretPassword!")
		.verifysuccessMessage("You logged into a secure area!");		
	}
	
	@Test(priority =0, description= "Verify the Login test with  invalid user name")
	public void invalid_UserName_Test() {
		LoginSuccessPage loginsuccesspage = new LoginSuccessPage(getDriver());
		loginsuccesspage.navigateToLoginSuccessPage()
		.tryLoginPage("abcde", "SuperSecretPassword!")
		.verifyInvalidUserName("Your username is invalid!");
	}
	
	@Test(priority =0, description= "Verify the Login test with invalid Password")
	public void invalid_Password_Test() {
		LoginSuccessPage loginsuccesspage = new LoginSuccessPage(getDriver());
		loginsuccesspage.navigateToLoginSuccessPage()
		.tryLoginPage("tomsmith", "abcde")
		.verifyInvalidPassword("Your password is invalid!");
	}
	
	@Test(priority =0, description= "Verify the Login test with empty username and Password")
	public void empty_Username_Password_Test() {
		LoginSuccessPage loginsuccesspage = new LoginSuccessPage(getDriver());
		loginsuccesspage.navigateToLoginSuccessPage()
		.tryLoginPage("", "")
		.verifyInvalidPassword("Your username is invalid!");
	}
	
//	@Test(priority = 0, description="Verify the Login page title")
//	public void verify_Login_Page_title() {
//		LoginSuccessPage loginsuccesspage = new LoginSuccessPage(getDriver());
//		loginsuccesspage.navigateToLoginSuccessPage()
//		.verifyPageTitle("Login Page");
//			
//	}
	
	
	

	

}
