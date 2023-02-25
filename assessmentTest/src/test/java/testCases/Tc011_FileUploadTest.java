package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.FileUploadPage;

public class Tc011_FileUploadTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/upload");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void FileUploadTest() throws IOException {
		FileUploadPage fup = new FileUploadPage(driver);
		String nameOfFile = fup.uploadFile();
		Assert.assertEquals(nameOfFile, "some-file.txt");
		logger.info("file name matches");
		bu.captureSrceenshot(driver, "FileUploadTest");
	}

}
