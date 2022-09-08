package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import util.BrowserFactory;

public class FileDownloadTest extends BrowserFactory {
	static FileDownloadPage fileDownloadPage;

	@BeforeMethod
	public static void beforeTests() {
		init("download");
		fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);
	}

	@Test(priority = 1)
	public static void testClicksOnFileAndValidatesFileIsDownloaded() {
		fileDownloadPage.clickFileDownloadHyperlink();
		
//		Open declaration of method below for commits of code
		
//		Unable to validate because I could not simply figure it out.
		fileDownloadPage.validateFileIsDownloaded();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
