package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class ContentBeforeAndAfterReload extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void contentChangeBeforeAndAfrerReload() throws InterruptedException {
		System.out.println("Test5: content Change Before And Afrer Reload");
		otherTests = new TestPage(driver);
		otherTests.contentBeforeAndAfterReload();
	}
}
