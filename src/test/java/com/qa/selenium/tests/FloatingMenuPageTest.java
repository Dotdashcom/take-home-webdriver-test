package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.FloatingMenuPage;

public class FloatingMenuPageTest extends TestBase{

	
	
	FloatingMenuPage floatingMenuPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "floating_menu");
		floatingMenuPage = new FloatingMenuPage();
	}
	
	@Test
	public void menuCheckTest() throws InterruptedException {
	//	Thread.sleep(2000);
		floatingMenuPage.scrollDown();
		Thread.sleep(3000);
		Assert.assertEquals(floatingMenuPage.menuDisplay(), true);
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
}
