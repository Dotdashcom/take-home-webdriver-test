package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FileDownloadPage;
import testbase.TestBase;

public class FileDownloadPageTest {

	WebDriver driver;
	FileDownloadPage fileDownloadPage;

	@Test(description = "User can download file")
	public void fileDownloadTest() {
		fileDownloadPage.clickLink();
		Boolean checkFile = fileDownloadPage.isFileDownloaded("some-file.txt");
		Assert.assertTrue(checkFile);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		fileDownloadPage = new FileDownloadPage(driver);
		fileDownloadPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
