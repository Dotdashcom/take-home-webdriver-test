package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.JavaScriptErrorPage;

public class JavaScriptErrorPageTest extends TestBase {
	JavaScriptErrorPage javaScriptErrorPage;

	public JavaScriptErrorPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		javaScriptErrorPage = new JavaScriptErrorPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void consoleErrors() {

		JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();
		Assert.assertTrue(javaScriptErrorPage.containsJsError("Cannot read property 'xyz' of undefined"),
				"The page doesn't contain the expected error");

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}