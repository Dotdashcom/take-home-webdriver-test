package com.dotDash.tests;

import org.testng.annotations.Test;
import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class DynamicControlsTest extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void dynamicControls() {
		System.out.println("Test6: Dynamic controls");
		otherTests = new TestPage(driver);
		
		otherTests.dynamicControls();
	}
}
