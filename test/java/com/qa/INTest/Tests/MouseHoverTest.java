package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.MouseHoverPage;
import com.qa.INTest.TestBase.TestBase;

public class MouseHoverTest extends TestBase {

	MouseHoverPage mhp;

	public MouseHoverTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		mhp = new MouseHoverPage();
		mhp.clickOnMouseHover();
	}

	@Test(priority = 1)
	public void vldFirstImageTest() {
		String expText = "name: user1";
		String actText = mhp.hoverOnFirstImage();
		Assert.assertTrue(expText.equals(actText));
	}

	@Test(priority = 2)
	public void vldSecondImageTest() {
		boolean flag = mhp.hoverOnSecondImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void vldThirdImageTest() {
		String expText = "name: user3";
		String actText = mhp.hoverOnThirdImage();
		System.out.println(actText);
		Assert.assertTrue(expText.equals(actText));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
