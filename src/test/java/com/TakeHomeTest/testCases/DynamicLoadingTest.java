package com.TakeHomeTest.testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.TakeHomeTest.pageObjects.DynamicLoadingPageObjects;

public class DynamicLoadingTest extends BaseClass{
	
	@Test
	public void dynamic_loading() {
		DynamicLoadingPageObjects dynpage=new DynamicLoadingPageObjects(driver);
		driver.get(url+"/dynamic_loading");
		
		dynpage.clickfirstlink();
		dynpage.ClickStart();
		
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
		String text=wait1.until(ExpectedConditions.visibilityOf(dynpage.helloworldtext)).getText();
		Assert.assertEquals(text, "Hello World!");
		
	}

}
