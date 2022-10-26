package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.FileUploadDownloadPageObjects;

public class FileUploadTest extends BaseClass{
	
	@Test
	public void Upload() {
		FileUploadDownloadPageObjects fileupdownpage=new FileUploadDownloadPageObjects(driver);
		driver.get(url+"/upload");
		
		fileupdownpage.ChooseFileButton.sendKeys("C:\\Users\\viji7\\OneDrive\\Desktop\\UploadFile.txt");
		fileupdownpage.ClickUpload();
		
		String receivedmessage=fileupdownpage.FileUploadedmsg.getText();
		Assert.assertEquals(receivedmessage, "File Uploaded!");
	}

}
