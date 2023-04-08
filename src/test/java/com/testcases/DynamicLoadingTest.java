package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.DynamicLoadingPage;


public class DynamicLoadingTest extends Base{
	
	DynamicLoadingPage dlp;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		dlp=new DynamicLoadingPage();
	}
	
	@Test
	public void validateThatHelloWorldTextisDisplayed() {
		dlp.clickOnStartBtn();
		dlp.explicitWait();
		Assert.assertTrue(dlp.checkHelloWorldTextIsPresent());
	
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
