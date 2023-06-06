package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class FileUploadTest extends BaseTest{
	TestPage otherTests ;
	
	@Test
	public void checkfileUpload() {
		System.out.println("Test 10: File Upload");
		otherTests = new TestPage(driver);
		otherTests.fileUpload();
	}

}
