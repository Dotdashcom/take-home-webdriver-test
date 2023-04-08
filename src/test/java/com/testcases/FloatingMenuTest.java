package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.FloatingMenuPage;


public class FloatingMenuTest extends Base {
	FloatingMenuPage fmp;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Floating Menu")).click();
		fmp=new FloatingMenuPage();
	}
	
	@Test
	public void validateTheFloatingMenuIsDisplayedWhenScrollToBottom() {
		fmp.scrollToBottomOfTheWebPage();
		Assert.assertTrue(fmp.validateFloatingMenuIsDisplayed());
		
	}
	@Test
	public void validateTheFloatingMenuIsDisplayedWhenScrollToMiddle() {
		fmp.scrollToMiddleOfTheWebPage();
		Assert.assertTrue(fmp.validateFloatingMenuIsDisplayed());
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
