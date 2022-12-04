package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FileUploadPage;
import baseTest.AbstractE2E;

public class FileUploadPageTest {

	WebDriver driver;
	FileUploadPage fileUploadPage;
	String fileName = "sample.txt";

	@Test(description = "Upload file using Button")
	public void TC01_fileUploadUsingButton_success() {
		String actualFile = fileUploadPage.uploadFileUsingButton(fileName);
		Assert.assertEquals(actualFile, fileName);
	}

	@Test(description = "Drag and Drop the file")
	public void TC02_dragAndDropFile_success() {
		String actualFile = fileUploadPage.uploadFileUsingDragAndDrop(fileName);
		Boolean fileExists = actualFile.contains(fileName);
		Assert.assertTrue(fileExists);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		fileUploadPage = new FileUploadPage(driver);
		fileUploadPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
