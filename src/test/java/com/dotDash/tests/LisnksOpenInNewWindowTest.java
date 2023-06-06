package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class LisnksOpenInNewWindowTest extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void openLinks() {
		System.out.println("17. Open in New Tab");
		otherTests = new TestPage(driver);
		
		otherTests.testLisnksOpenInNewWindow();
	}
}

