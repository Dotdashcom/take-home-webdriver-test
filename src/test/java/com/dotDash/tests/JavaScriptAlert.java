package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class JavaScriptAlert extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void jsAlert() {
		System.out.println("15. JavaScript Alerts");
		otherTests = new TestPage(driver);
		otherTests.javaScriptAlerts();
	}
}
