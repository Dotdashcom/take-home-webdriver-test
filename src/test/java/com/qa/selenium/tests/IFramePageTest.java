package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.IFramePage;

public class IFramePageTest extends TestBase{

	IFramePage iFramePage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "iframe");
		iFramePage = new IFramePage();
	}
	
	@Test
	public void InputText() throws InterruptedException {

		iFramePage.write();
		Thread.sleep(1000);
		Assert.assertEquals(iFramePage.verifyText(), prop.getProperty("FrameText"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
