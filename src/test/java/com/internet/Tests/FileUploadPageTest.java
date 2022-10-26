package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.FileDownloadPage;
import com.internet.pages.FileUploadPage;
import com.internet.pages.Page;
import com.internet.pages.TheInternetPage;

public class FileUploadPageTest extends Baseclass {
	TheInternetPage internet;
	FileUploadPage upload;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		upload = internet.clickFileUpload();
	}

	@Test
	public void verifyUploadTest() {
		upload.chooseFileSendKeys("C:\\Users\\LENOVO\\Desktop\\file.txt");
		upload.clickUpload();
		Assert.assertEquals(upload.getHeaderText(), "File Uploaded!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
