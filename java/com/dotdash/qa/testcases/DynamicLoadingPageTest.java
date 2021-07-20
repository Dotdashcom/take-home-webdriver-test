package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DynamicLoadingPage;

public class DynamicLoadingPageTest extends TestBase {

	DynamicLoadingPage dynamicLoadingPage;

	public DynamicLoadingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dynamicLoadingPage = new DynamicLoadingPage();
	}

	@Test(priority = 1)
	public void visibleElement() {
		boolean visible = dynamicLoadingPage.hiddenElement();
		Assert.assertEquals(false, visible);
	}

	@Test(priority = 2)
	public void addingElement() {
		boolean visible = dynamicLoadingPage.addingElemnt();
		Assert.assertEquals(false, visible);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
