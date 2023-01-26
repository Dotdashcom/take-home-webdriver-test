package com.qa.selenium.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DynamicLoadingPage;

public class DynamicLoadingPageTest extends TestBase{
	DynamicLoadingPage dynamicLoadingPage;

	@BeforeMethod
	public void setup() {
		initialization();		
		driver.get(prop.getProperty("URL") + "dynamic_loading/2");
		dynamicLoadingPage = new DynamicLoadingPage();
	}
	
	
	@Test
	public void DynamicTest() {
		dynamicLoadingPage.startBtnClick();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(dynamicLoadingPage.TextElement(), "Hello World!"));
		Assert.assertEquals(prop.getProperty("dynamicText"), dynamicLoadingPage.HelloText());
	}
	
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
