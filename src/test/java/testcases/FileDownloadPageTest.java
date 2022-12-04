package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FileDownloadPage;
import baseTest.AbstractE2E;

public class FileDownloadPageTest {

	WebDriver driver;
	FileDownloadPage fileDownloadPage;

	@Test(description = "User can download file")
	public void TC01_fileDownloadTest_success() {
		fileDownloadPage.clickLink();
		Boolean checkFile = fileDownloadPage.isFileDownloaded("some-file.txt");
		Assert.assertTrue(checkFile);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		fileDownloadPage = new FileDownloadPage(driver);
		fileDownloadPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
