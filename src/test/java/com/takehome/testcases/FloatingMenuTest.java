package com.takehome.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.FloatingMenu;

public class FloatingMenuTest {
	DriverScript driverSetup;
	FloatingMenu page;
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}
	
	@Test
	public void floatingmenu()
	{
		page = new FloatingMenu(driverSetup.getDriver(), driverSetup.getBaseURL());
		JavascriptExecutor jse = (JavascriptExecutor)driverSetup.getDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
		Assert.assertTrue(page.getFloatingMenu().isDisplayed());
		 
	}
	
	
	
	
	
	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}

}
