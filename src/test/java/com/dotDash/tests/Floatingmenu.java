package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class Floatingmenu extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void flotingMenu() {
		System.out.println("Test 13. IFrame");
		otherTests = new TestPage(driver);
		otherTests.floatingMenu();
	}

}
