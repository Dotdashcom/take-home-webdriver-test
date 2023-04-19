package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.FileUploadPage;
import com.qa.dotdash.pages.HomePage;

public class FileUploadPageTest extends BaseClass {
	HomePage homePage;
	FileUploadPage upload;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		upload = homePage.clickFileUpload();
	}

	@Test
	public void verifyUploadTest() {
		upload.chooseFileSendKeys("F:\\nature.jpeg");
		upload.clickUpload();
		Assert.assertEquals(upload.getHeaderText(), "File Uploaded!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
