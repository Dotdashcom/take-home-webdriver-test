package com.dotdash.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.FileDownloadPage;

public class FileDownloadTest extends TestBase {
	
	FileDownloadPage fileDownloadPage;
	
	public FileDownloadTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		fileDownloadPage = new FileDownloadPage();	
	}
	
	@Test()
	public void checked() throws InterruptedException{
		
		String filePath = System.getProperty("user.home")+"\\Downloads\\";
		fileDownloadPage.fileCheck(filePath);
		Assert.assertTrue(fileDownloadPage.fileCheck(filePath), "File is not downloaded as expected");
	}	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
}
