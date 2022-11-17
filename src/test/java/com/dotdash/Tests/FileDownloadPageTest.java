package com.dotdash.Tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.FileDownloadPage;
import com.dotdash.Pages.InternetPage;

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
