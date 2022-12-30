package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.ContextMenuPage;
import com.qa.INTest.TestBase.TestBase;

public class ContextMenuTest extends TestBase {
	ContextMenuPage cmp;

	public ContextMenuTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		cmp = new ContextMenuPage();
		cmp.clickOnContextMenuLink();
	}

	@Test
	public void vldContextMenu() {

		boolean flag = cmp.performRightClick();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
