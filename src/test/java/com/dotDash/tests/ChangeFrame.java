package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class ChangeFrame extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void changeFrameAndEnterText() {
		System.out.println("Test 13. IFrame");
		otherTests = new TestPage(driver);
		otherTests.changeFrame();
	}
	

}
