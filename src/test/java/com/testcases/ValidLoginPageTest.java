package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class ValidLoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public ValidLoginPageTest(){
		super();
	}
	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	@Test(priority=1)
	public void launchApp() {
		  driver.get(prop.getProperty("loginURL"));
	  }
	@Test(priority=2)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "The Internet");
	}
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}	
	
	@Test(priority=4)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "The Internet","Home page title not matched");
	}
	@Test(priority=4)
	public void verifyHomePageSecureAreaLabelTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "The Internet","Home page title not matched");
	}
	@Test(priority=5)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifysecureAreaLabel());
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		// terminates driver session and closes all windows
	}
	
	
	
	

}
