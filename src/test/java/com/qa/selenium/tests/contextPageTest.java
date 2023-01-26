package com.qa.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.ContextMenuPage;
import com.qa.selenium.pages.LoginPage;

public class contextPageTest extends TestBase{
	
	ContextMenuPage contextMenuPage;
	LoginPage loginpage;
	
	public contextPageTest() {
		
	super();
	}
	
	@BeforeMethod
	
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "context_menu");
		contextMenuPage = new ContextMenuPage();
		
	}
	
		@Test
		public void contextTest() {
			contextMenuPage.clickOnContext();
		String expected =	contextMenuPage.alertConfirm();
			Assert.assertEquals(expected, prop.getProperty("alert"));
		}
		
		
		
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}


	
	
	
	
	

}
