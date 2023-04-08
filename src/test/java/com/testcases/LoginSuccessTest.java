package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;


import com.base.TestBase;
import com.pages.LoginSuccessPage;
import com.pages.LoginPage;

public class LoginSuccessTest extends TestBase {
	
	LoginPage lp;
	LoginSuccessPage ls;
	
	public LoginSuccessTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		lp= new LoginPage();
		ls=lp.loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyLoginSuccessPageURLTest() {
		
		String actualUrl= getCurrentUrl();;
		Assert.assertEquals(actualUrl,prop.getProperty("expectedUrl"));
	}
	
	@Test
	public void verifyTheUserLoggedInSuccessfully() {

		String actualLoginSuccessMessage=getTheflashMessages();
		Assert.assertEquals(actualLoginSuccessMessage,prop.getProperty("expectedLoginSuccessMessage")+'\n'+"×");
	}
		
	@Test
	public void verifyWelcomeMessagePresent() {
		String actualWelcomeText=ls.validateWelcomeMessagePresent();
		Assert.assertEquals(actualWelcomeText,prop.getProperty("expectedWelcomeText"));
	}
	@Test
	public void verifyLogoutButtonIsDisplayed() {	
		boolean logoutBtnDisplayed=ls.validateTheLogoutButtonIsDisplayed();
		Assert.assertTrue(logoutBtnDisplayed,"Logout Button Is Displayed");
	}
	
	@Test
	public void clickonLogoutButton() {
		lp=ls.clickOnLogoutButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
