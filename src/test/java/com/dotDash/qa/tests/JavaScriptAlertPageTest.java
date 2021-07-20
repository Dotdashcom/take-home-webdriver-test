package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.JavaScriptAlertPage;

public class JavaScriptAlertPageTest extends TestBase{
	
	JavaScriptAlertPage javaScriptAlertPage;
	
	public JavaScriptAlertPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		javaScriptAlertPage = new JavaScriptAlertPage();	
	}
	
	@Test(priority=1)
	public void alert(){
		String alert= javaScriptAlertPage.alertJava();
		Assert.assertEquals("I am a JS Alert", alert);	
	}	
	
	@Test(priority=2)
	public void confirm(){
		String confirm = javaScriptAlertPage.confirmJava();
		Assert.assertEquals("I am a JS Confirm", confirm);
	}
	
	@Test(priority=3)
	public void prompt(){
		String prompt = javaScriptAlertPage.promptJava();
		Assert.assertEquals("You entered: " + "Hello_World", prompt);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
