package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.NewTabPage;

public class NewTabPageTest  extends TestBase{

	NewTabPage newTabPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "windows");
		newTabPage = new NewTabPage();
	}
	
	@Test
	public void NewWindowTest() {
		newTabPage.window();
		Assert.assertEquals(newTabPage.windowText(), prop.getProperty("windowText"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
