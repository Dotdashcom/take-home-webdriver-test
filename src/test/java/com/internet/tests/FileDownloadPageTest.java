package com.internet.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.DynamicPageLoaded;
import com.internet.pages.DynamicPageLoading;
import com.internet.pages.FileDownloadPage;
import com.internet.pages.InternetPage;
import com.internet.utils.Utils;

public class FileDownloadPageTest extends BaseClass {
	InternetPage internet;
	FileDownloadPage download;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		download = internet.clickFileDownload();
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