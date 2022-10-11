package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.JavascriptErrorPage;
import com.tjank.PageObjectModel.WebPage;

public class JavascriptErrorTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void jsErrorPageTest() {
		JavascriptErrorPage erPage = new JavascriptErrorPage();
		erPage.setup();
		erPage.waitForPageToLoad();
		erPage.validateErrorMessage();
	}
}
