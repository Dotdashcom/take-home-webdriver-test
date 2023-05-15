package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import pageObjectModel.FileDownloadPage;
import pageObjectModel.HomePage;

public class FileDownloadTest extends BaseTest {	
	@Test
	public void fileDownload() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		FileDownloadPage fileDownload = homepage.clickFileDown();
		fileDownload.downLoadFile();
		assertTrue(fileDownload.isExist());
	}
}
