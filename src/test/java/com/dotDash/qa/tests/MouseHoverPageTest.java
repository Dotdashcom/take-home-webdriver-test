package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.MouseHoverPage;

public class MouseHoverPageTest extends TestBase{
	MouseHoverPage mouseHoverPage;
	
	public MouseHoverPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mouseHoverPage = new MouseHoverPage();	
	}
	
	@Test(priority=1)
	public void checked(){
		boolean hover = mouseHoverPage.mouseHover();
		Assert.assertEquals(true, hover);
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
