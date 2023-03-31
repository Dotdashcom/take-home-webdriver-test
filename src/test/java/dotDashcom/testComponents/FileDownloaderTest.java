package dotDashcom.testComponents;


import org.testng.Assert;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import dotDashcom.pageObjects.FileDownloaderPage;


public class FileDownloaderTest extends BaseTest{
	FileDownloaderPage fileDownloader;
	
	@Before
	public void setup() throws IOException {
		setup("/download");
		fileDownloader=new FileDownloaderPage(driver);
	}
	
	@Test
	public void checkFileDownload() throws AWTException{
		fileDownloader.fileDownload();
		boolean download=fileDownloader.verifyFileDownload();
		Assert.assertTrue(download, "File Download Successful");
	}
}
