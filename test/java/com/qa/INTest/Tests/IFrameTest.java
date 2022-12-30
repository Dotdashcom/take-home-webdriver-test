package com.qa.INTest.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.IFramePage;
import com.qa.INTest.TestBase.TestBase;

public class IFrameTest extends TestBase {
	IFramePage ifp;

	public IFrameTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		ifp = new IFramePage();
		ifp.clickOnIFrame();
	}

	@Test
	public void vldtypeTextTest() throws IOException, InterruptedException, AWTException {
		String expText = "Your content goes here.";
		String actText = ifp.typeText();
		Assert.assertEquals(actText, expText);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
