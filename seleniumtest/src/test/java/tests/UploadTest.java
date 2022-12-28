package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.UploadPage;

public class UploadTest extends GenericPage {
	UploadPage uploadPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/upload");
		uploadPage = new UploadPage();
	}

	@Test
	public void tcUpload() throws InterruptedException {
		String path = "C:\\Users\\neera\\Downloads\\some-file-copy.txt";
		uploadPage.chooseFileButton.sendKeys(path);
		uploadPage.uploadButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(uploadPage.message.getText(), "File Uploaded!");
	}
}