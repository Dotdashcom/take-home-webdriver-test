package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.DynamicLoadingPage;

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

	// Testing and asserting the value
	@Test(priority = 1)
	public void visibleElement() {
		boolean visible = dynamicLoadingPage.hiddenElement();
		Assert.assertEquals(false, visible);
	}

	// Testing and asserting the value
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
