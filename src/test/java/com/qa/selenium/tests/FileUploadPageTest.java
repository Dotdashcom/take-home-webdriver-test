package com.qa.selenium.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.FileUploadPage;

public class FileUploadPageTest extends TestBase {

	FileUploadPage fileUploadPage;

	@BeforeMethod 
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "upload");
		fileUploadPage = new FileUploadPage();
	}
	
	@BeforeTest 
	public void fileCreate() throws IOException{
		File f = new File("C:\\Users\\yashh\\Downloads\\sample-upload-text.txt");
		f.createNewFile();
		
		
	}
	
	
	@Test
	public void performeUpload() throws InterruptedException  {
		fileUploadPage.selectBrowse();
		fileUploadPage.selectupload();
		Assert.assertEquals(fileUploadPage.verifyUpload(), prop.getProperty("UploadVerify"));
		
	}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
}
