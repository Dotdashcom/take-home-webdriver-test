package com.dotDash.tests;

import org.testng.annotations.Test;

import com.dotDash.Pages.TestPage;
import com.dotDash.basePages.BaseTest;

public class FileDownloadTest extends BaseTest{
	
	TestPage otherTests ;
	
	@Test
	public void checkFileDownLoad() throws InterruptedException {
		System.out.println("Test7: File download");
		otherTests = new TestPage(driver);
		otherTests.fileDownload();
	}

}
