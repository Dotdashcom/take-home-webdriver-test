package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class MouseHoverTest extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void mouseHover() {
		System.out.println("14. Mouse hover");
		otherTests = new TestPage(driver);
		otherTests.mouseHover();
	}

}
