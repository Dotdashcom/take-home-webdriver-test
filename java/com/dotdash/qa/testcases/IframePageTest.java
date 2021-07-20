package com.dotdash.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.IframePage;

public class IframePageTest extends TestBase {
	IframePage iframePage;
	
	public IframePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		iframePage = new IframePage();	
	}
	
	@Test(priority=1)
	public void checked(){
		iframePage.iframe();
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
