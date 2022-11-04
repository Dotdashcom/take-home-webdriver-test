package com.Dotdashcom.Tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.FileDownLoadPage;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;



public class FileToDownLoadPageTest extends TestBase {
HomePage homePage;
	FileDownLoadPage fileDownLoadPage;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		fileDownLoadPage = homePage.clickFileDownload();
	}

	@Test
	public void verifyDownloadTest() {
		fileDownLoadPage.clickLink();
		ProxyDriver.sleep(5000);
		String home = System.getProperty("user.home");
		home = home + "/Downloads/";
		File folder = new File(home);
		File[] listOfFiles = folder.listFiles();
		boolean found = false;

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				if (fileName.contains("some-file")) {

					found = true;
				}
			}
		}
		Assert.assertTrue(found, "Download not successful");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}