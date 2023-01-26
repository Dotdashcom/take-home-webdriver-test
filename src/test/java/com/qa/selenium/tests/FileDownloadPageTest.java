package com.qa.selenium.tests;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.FileDownloadPage;

public class FileDownloadPageTest extends TestBase{
	FileDownloadPage fileDownloadPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "download");
		fileDownloadPage = new FileDownloadPage();
	}
	
	@Test
	public void checkDownloadTest() throws InterruptedException {
		fileDownloadPage.DownloadStart();
		File f = new File("C:\\Users\\yashh\\Downloads");
		Thread.sleep(3000);
		
		boolean check = f.exists();
		Assert.assertEquals(check, true, "Cound not find the File");
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
