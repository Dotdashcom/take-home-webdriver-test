package RamanpreetSinghtest.SeleniumTest;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FileDownloadPage;
import TestComponents.BaseTest;

public class FileDownloadTest extends BaseTest {

	@Test
	public void fileDownload() throws InterruptedException {
		FileDownloadPage filedownloadpage = landingpage.getfiledownloadPage();
		File file = filedownloadpage.fileDownload();
		if (file.exists()) {
			Assert.assertTrue(file.exists());
		} else {
			Assert.fail("file not found");
		}
	}
}
