package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DownloadPage;
import com.dotdash.util.DriverUtil;

public class TestDownload extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test downloading file")
	private void testDownload() {
		DownloadPage downLoadPage = navigateTo(driver, DownloadPage.class);
		downLoadPage.verifyPage();

		downLoadPage.downloadFile();
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
