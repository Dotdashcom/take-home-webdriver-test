package com.qa.INTest.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.FloatingMenuPage;
import com.qa.INTest.TestBase.TestBase;

public class FloatingMenuTest extends TestBase {

	FloatingMenuPage fmp;

	public FloatingMenuTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		fmp = new FloatingMenuPage();
		fmp.clickOnFloatingMenu();
	}

	@Test
	public void vldFileUploadTest() throws IOException, InterruptedException, AWTException {

		boolean flag = fmp.scorllThePage();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
