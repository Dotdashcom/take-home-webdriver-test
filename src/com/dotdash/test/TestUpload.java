package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.UploadPage;
import com.dotdash.util.DriverUtil;

public class TestUpload extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test uploading file and land on confirmation page")
	private void testUpload() {
		UploadPage uploadPage = navigateTo(driver, UploadPage.class);
		uploadPage.verifyPage();

		uploadPage.upload("c:/tmp/some-file.txt"); // Unfortunately I only have a Win 10 computer
		uploadPage.verifyUploadConfirmation("some-file.txt");
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
