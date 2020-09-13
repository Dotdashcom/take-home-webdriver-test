package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.FileUploadPage;

public class FileUploadPageTest extends TestBase{

	
	FileUploadPage fileUploadPage;
	
	
	@BeforeMethod
	public void setup(){
		initialization("/upload");
		fileUploadPage = new FileUploadPage();
	}
	
	@Test(priority = 1)
	public void uploadFileTest() {
		String result  = fileUploadPage.uploadFileTest();
		Assert.assertEquals(result, "File Uploaded!", "File not uploaded");
	}
}
