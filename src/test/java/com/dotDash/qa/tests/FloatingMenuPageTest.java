package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.FloatingMenuPage;

public class FloatingMenuPageTest extends TestBase {
	FloatingMenuPage floatingMenuPage;

	public FloatingMenuPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		floatingMenuPage = new FloatingMenuPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void checked() {
		boolean menuVisible = floatingMenuPage.floatingMenu();
		Assert.assertEquals(true, menuVisible);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
