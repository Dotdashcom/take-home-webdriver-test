package com.TakeHomeTest.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.FloatingmenuPageObjects;

public class FloatingMenuTest extends BaseClass{

	@Test
	public void floatingmenu() {
		FloatingmenuPageObjects floatpage=new FloatingmenuPageObjects(driver);
		driver.get(url+"/floating_menu ");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 2500)");
		
		boolean checkmenu=floatpage.CheckMenuIsDisplayed();
		Assert.assertTrue(checkmenu);
	}
}
