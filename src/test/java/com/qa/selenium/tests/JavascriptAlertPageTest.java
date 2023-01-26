package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.JavascriptAlertPage;
import com.qa.selenium.util.TestUtil;

public class JavascriptAlertPageTest extends TestBase{

	
	JavascriptAlertPage javascriptAlertPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "javascript_alerts");
		javascriptAlertPage = new JavascriptAlertPage();
	}
	
	@Test(priority =1)
	public void JSAlert() throws InterruptedException {
		javascriptAlertPage.jsalert();
		Assert.assertEquals(TestUtil.alText, prop.getProperty("jsAlert"));
	}
	
	@Test(priority= 2)
	public void JSConfirm() throws InterruptedException {
		javascriptAlertPage.jsconfirm();
		Assert.assertEquals(TestUtil.jsConfirmText, prop.getProperty("jsConfirmText"));
	}
	
	@Test(priority= 3)
	public void JSPrompt() throws InterruptedException {
		javascriptAlertPage.jspropmpt();
		Assert.assertEquals(javascriptAlertPage.jsPromptResult(), prop.getProperty("jsPromptkeys"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	
	
}
