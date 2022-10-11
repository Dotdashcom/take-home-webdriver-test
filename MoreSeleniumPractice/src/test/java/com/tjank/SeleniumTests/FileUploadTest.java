package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.FileUploadPage;
import com.tjank.PageObjectModel.WebPage;

public class FileUploadTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void uploadFileTest() {
		FileUploadPage fupPage = new FileUploadPage();
		fupPage.setup();
		fupPage.waitForPageToLoad();
		fupPage.uploadFile("some-file.txt");
		fupPage.verifyFileUploaded("some-file.txt");
	}
}
