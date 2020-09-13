package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.FileDownLoadPage;

public class FileDownloadPageTest extends TestBase{
	
	FileDownLoadPage fileDownloadPage;
	
	@BeforeMethod
	public void setup(){
		initialization("/download");
		fileDownloadPage = new FileDownLoadPage();
	}
	
	@Test(priority = 1)
	public void loginSuccessTest() {
		boolean b = fileDownloadPage.downloadFileTest();
		Assert.assertTrue(b, "Test case is passed");
	}
	
	

}
