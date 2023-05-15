package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pageObjectModel.FileUploadPage;
import pageObjectModel.HomePage;

public class FileUploadTest extends BaseTest{	
	@Test
	public void fileUpload() {
		HomePage homepage = new HomePage(driver);
		FileUploadPage fileUpload = homepage.clickFileUpload();
		fileUpload.uploadFile();
		assertEquals(fileUpload.uploadMessage(), "File Uploaded!");		
	}
}
