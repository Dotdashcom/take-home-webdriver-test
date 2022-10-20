package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.FileDownloadPage;
import com.internet.pages.FileUploadPage;
import com.internet.pages.Page;
import com.internet.pages.InternetPage;

public class FileUploadPageTest extends BaseClass {
	InternetPage internet;
	FileUploadPage upload;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		upload = internet.clickFileUpload();
	}

	@Test
	public void verifyUploadTest() {
		upload.chooseFileSendKeys("C:\\Users\\images\\image.jpg");
		upload.clickUpload();
		Assert.assertEquals(upload.getHeaderText(), "File Uploaded!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}