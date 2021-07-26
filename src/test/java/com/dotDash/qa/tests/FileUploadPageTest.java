package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.FileUploadPage;

public class FileUploadPageTest extends TestBase {

	FileUploadPage fileUploadPage;

	public FileUploadPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		fileUploadPage = new FileUploadPage();
	}

	// Testing and asserting the value
	@Test()
	public void fileUpload() throws InterruptedException {
		String fileName = "some-file.txt";
		String fileDir = System.getProperty("user.home") + "\\Downloads\\";
		Assert.assertEquals(fileUploadPage.uploadFile(fileDir + fileName).trim(), fileName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
