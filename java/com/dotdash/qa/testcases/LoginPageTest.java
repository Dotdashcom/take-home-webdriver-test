package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "The Internet");
	}
	
	
	 @Test(priority=2) public void loginTest(){
		 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
		/* Login fail test case running successfully
		 * @Test(priority=4) public void loginFailTest(){ loginPage.login("Test","Test"
		 * ); }
		 */	

	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
