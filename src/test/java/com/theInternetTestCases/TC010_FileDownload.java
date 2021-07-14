package com.theInternetTestCases;

import org.testng.annotations.Test;

import com.theInternetPages.LoginPage;
import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC010_FileDownload extends DriverScript {

	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("FileDownloadURL"));

		getPageObject().getFileDownloadPage().isDisplayedPage();

	}

	@Test(priority = 2)
	public void verifyFileDownload() throws InterruptedException {
		getPageObject().getCommonActions().deleteFiles(System.getProperty("user.dir") + File.separator + "Downloads");
		getPageObject().getFileDownloadPage().clickFileLnk();
		Assert.assertTrue((getPageObject().getCommonActions()
				.getFileName(System.getProperty("user.dir") + File.separator + "Downloads")).equalsIgnoreCase(
						getPageObject().getFileDownloadPage().getFileName()),
				"File has not been downloaded");
		Reporter.log("File has been downloaded successfully");

	}

	@BeforeTest

	public void setUp() {
		try {
			launchBrowser();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to Launch the browser");
		}

	}

	@AfterTest
	public void afterTest() {
		getDriver().close();
		getDriver().quit();
	}

}
