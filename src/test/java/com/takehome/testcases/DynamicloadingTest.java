package com.takehome.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.DynamicLoading;

public class DynamicloadingTest {
	DriverScript driverSetup;
	DynamicLoading page;
	
	
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}
	
	
	
	@Test
	public void dynamicloading()
	{
		page = new DynamicLoading(driverSetup.getDriver(), driverSetup.getBaseURL());
		WebDriverWait wait = new WebDriverWait(driverSetup.getDriver(), 20);
		page.getStartButton().click();
		wait.until(ExpectedConditions.textToBePresentInElement(page.getFinishDiv(),"Hello World!"));
		Assert.assertEquals(page.getFinishDiv().getText(), "Hello World!");
		
	}
	
	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}
	
	
	
}
