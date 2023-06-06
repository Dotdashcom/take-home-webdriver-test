package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class JsErrorsonWebPageTest extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void checkJserrors() {
		System.out.println("16.JavaScript Error");
		otherTests = new TestPage(driver);
		otherTests.jsError();
	}

}
