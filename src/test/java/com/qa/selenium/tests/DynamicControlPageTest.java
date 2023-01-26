package com.qa.selenium.tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DynamicControlPage;

public class DynamicControlPageTest extends TestBase {
	
	DynamicControlPage dynamicControlPage;
	
	
	public DynamicControlPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "dynamic_controls");
		dynamicControlPage = new DynamicControlPage();
	}
	
	
	@Test(priority=1)
	public void removeAddTest() {
		
		dynamicControlPage.AddAndRemoveClick();
		  WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.checkbox()));
		
	//	System.out.println(dynamicControlPage.addremoveText() + " TEXT IS VISIBLE");
		
	Assert.assertEquals(prop.getProperty("dynamicRemove"), dynamicControlPage.addremoveText(), "Assert Failed: It's gone! not present");
		
		dynamicControlPage.AddAndRemoveClick();
		wait.until(ExpectedConditions.visibilityOf(dynamicControlPage.checkbox()));
		
	Assert.assertEquals(prop.getProperty("dynamicAdd"), dynamicControlPage.addremoveText(), "Assert failed: It's back! not present");
	
	}
	
	@Test(priority=2)
	public void enableDisableTest() {
		
		dynamicControlPage.EnableAndDisableClick();
		
		WebDriverWait wait = new WebDriverWait (driver ,5);
		wait.until(ExpectedConditions.visibilityOf(dynamicControlPage.textboxNotPresent()));
		
		Assert.assertEquals(prop.getProperty("dynamicEnable"), dynamicControlPage.enabledisableText(), "Assert Failed: It's enable, not present");
		
		dynamicControlPage.EnableAndDisableClick();
		wait.until(ExpectedConditions.elementToBeClickable(dynamicControlPage.textboxPresent()));
	//	System.out.println(dynamicControlPage.enabledisableText());
		Assert.assertEquals(prop.getProperty("dynamicDisable"), dynamicControlPage.enabledisableText());
		
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
