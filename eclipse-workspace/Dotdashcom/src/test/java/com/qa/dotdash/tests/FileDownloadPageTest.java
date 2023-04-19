package com.qa.dotdash.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.FileDownloadPage;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.utils.Utils;

public class FileDownloadPageTest extends BaseClass {
HomePage homePage;
	FileDownloadPage download;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		download = homePage.clickFileDownload();
	}

	@Test
	public void verifyDownloadTest() {
		download.clickLink();
		Utils.sleep(20000);
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
