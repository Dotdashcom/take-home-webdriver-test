package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;


import com.base.Base;
import com.pages.DynamicContentPage;

public class DynamicContentTest extends Base{
	
	DynamicContentPage dcp;
	@BeforeMethod
	public void setUp() {
	initialization();
	driver.findElement(By.linkText("Dynamic Content")).click();
	dcp=new DynamicContentPage();
	}
	

	@Test
	public void verifyThatContentChangesOnEachRefresh() {

		String contentBeforePageRefresh=dcp.getContentText();
		dcp.refreshThePage();
		String contentAfterRefresh=dcp.getContentText();
		Assert.assertNotEquals(contentBeforePageRefresh, contentAfterRefresh);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
