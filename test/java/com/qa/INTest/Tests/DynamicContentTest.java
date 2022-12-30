package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.DynamicContentPage;
import com.qa.INTest.TestBase.TestBase;

public class DynamicContentTest extends TestBase {
	DynamicContentPage dcp;

	public DynamicContentTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		dcp = new DynamicContentPage();
		dcp.clickDynamicContentLink();
	}

	@Test
	public void vldDynamicContentTest() {
		dcp.getDynamicContent();
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
