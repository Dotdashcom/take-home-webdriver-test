package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import util.BrowserFactory;

public class FileUploadTest extends BrowserFactory {
	static FileUploadPage fileUploadPage;

	@BeforeMethod
	public static void beforeTests() {
		init("upload");
		fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
	}

	@Test(priority = 1)
	public static void testUsesUploadButtonToUploadAFileAndValidatesFileIsUploaded() {
		fileUploadPage.uploadFile();
		fileUploadPage.clickUploadButton();
		fileUploadPage.validateFileIsUploaded();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
