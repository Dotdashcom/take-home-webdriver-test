package testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.FileDownloadPage;

public class Tc010_FileDownloaderTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/download");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void FileDownloaderTest() throws IOException {
		FileDownloadPage fdp = new FileDownloadPage(driver);
		fdp.fileDownload();
		bu.captureSrceenshot(driver, "FileDownloaderTest");
	}
}
