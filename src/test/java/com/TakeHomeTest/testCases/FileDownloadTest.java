package com.TakeHomeTest.testCases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import com.TakeHomeTest.pageObjects.FileUploadDownloadPageObjects;

public class FileDownloadTest extends BaseClass{
	
	@Test
	public void download() {
		FileUploadDownloadPageObjects fileupdownpage=new FileUploadDownloadPageObjects(driver);
		driver.get(url+"/download");
		
		boolean flag=false;

		fileupdownpage.clickDownload();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		File fileLocation=new File("C:\\Users\\viji7\\Downloads");
		File[] totalFiles=fileLocation.listFiles();
		for (File file : totalFiles) {
			if(file.getName().contains("some-file.txt"))
			{
				System.out.println("File is downloaded");
				break;
			}
			flag=true;
			Assert.assertTrue(flag);

		}
	}

	
}
