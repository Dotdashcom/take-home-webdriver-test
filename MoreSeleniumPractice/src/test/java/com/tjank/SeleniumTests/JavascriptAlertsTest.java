package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.JavascriptAlertsPage;
import com.tjank.PageObjectModel.WebPage;

public class JavascriptAlertsTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void jsAlertTest() {
		JavascriptAlertsPage jsPage = new JavascriptAlertsPage();
		jsPage.setup();
		jsPage.waitForPageToLoad();
		jsPage.verifyAlertMessage();
		jsPage.verifyAlertConfirm();
		jsPage.verifyAlertPrompt();
	}
}
