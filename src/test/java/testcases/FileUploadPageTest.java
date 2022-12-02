package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FileUploadPage;
import testbase.TestBase;

public class FileUploadPageTest {

	WebDriver driver;
	FileUploadPage fileUploadPage;

	@Test(priority = 1, description = "Upload file using Button")
	public void fileUploadUsingButton() {
		String fileName = "some-file.txt";
		String actualFile = fileUploadPage.uploadFileUsingButton(fileName);
		Assert.assertEquals(actualFile, fileName);
	}

	@Test(priority = 2, description = "Drag and Drop the file")
	public void dragAndDropFile() {
		String fileName = "some-file.txt";
		String actualFile = fileUploadPage.uploadFileUsingDragAndDrop(fileName);
		Boolean fileExists = actualFile.contains(fileName);
		Assert.assertTrue(fileExists);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		fileUploadPage = new FileUploadPage(driver);
		fileUploadPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
