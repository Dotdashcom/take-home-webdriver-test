package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.FileDownloadUploadPage;

public class FileUploadTest extends BaseClass {
	FileDownloadUploadPage fileDownUpLoadPageObj;

	public FileUploadTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/upload");
		fileDownUpLoadPageObj = new FileDownloadUploadPage();
	}

	@Test
	public void Download() throws InterruptedException {
		String filePath = "F:\\Farook_workspace\\mohamedfarook\\Screenshot 2022-12-16 160255.png";
		fileDownUpLoadPageObj.chooseFileButton.sendKeys(filePath);
		fileDownUpLoadPageObj.UploadButton.click();
		Thread.sleep(4000);
		Assert.assertEquals(fileDownUpLoadPageObj.fileUploadedText.getText(), "File Uploaded!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
