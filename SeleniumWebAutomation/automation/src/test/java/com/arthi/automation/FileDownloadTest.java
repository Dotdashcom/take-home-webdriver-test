package com.arthi.automation;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.FileDownloadPage;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class FileDownloadTest extends TestBase {
	
	@Test
	public void testDownloadFileTest_For_someFile() throws InterruptedException {
		FileDownloadPage filedownloadPage =  new FileDownloadPage(getDriver(), this.downloadDir);
		filedownloadPage.navigateToFileDownloadPage().verifyFiledownloadEvent("some-file.txt");
	}
	
	@AfterClass
	public void cleanUp() throws InterruptedException {
		File folder = new File(this.downloadDir);
		if (folder.isDirectory()) {
			for(File file:folder.listFiles()) {
				Thread.sleep(20000);
				file.delete();
			}
		}
	}
}
