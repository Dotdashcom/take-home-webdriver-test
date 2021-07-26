package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.ContextMenuPage;

public class ContextMenuPageTest extends TestBase {
	ContextMenuPage contextMenuPage;

	public ContextMenuPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		contextMenuPage = new ContextMenuPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void checked() {
		String alert = contextMenuPage.contextMenu();
		Assert.assertEquals("You selected a context menu", alert);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
