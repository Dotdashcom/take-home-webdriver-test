package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.DragAndDropPage;

public class DragAndDropPageTest extends TestBase {
	DragAndDropPage dragAndDropPage;

	public DragAndDropPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dragAndDropPage = new DragAndDropPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void dragAndDrop() {

		boolean actual = dragAndDropPage.dragAndDrop();
		try {
			Assert.assertEquals(actual, false);
		} catch (Exception e) {
			e.getLocalizedMessage();
			Assert.assertTrue(true);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
