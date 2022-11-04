package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.FileUploadPage;
import com.Dotdashcom.Pages.HomePage;



public class FileUploadPageTest extends TestBase {
	HomePage homePage;
	FileUploadPage fileUploadPage;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		fileUploadPage = homePage.clickFileUpload();
	}

	@Test
	public void verifyUploadTest() {
		fileUploadPage.chooseFileSendKeys("C:\\Users\\tintu\\git\\take-home-webdriver-test\\src\\main\\java\\com\\Dotdashcom\\Config\\Config.Properties");
		fileUploadPage.clickUpload();
		Assert.assertEquals(fileUploadPage.getHeaderText(), "File Uploaded!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
 
