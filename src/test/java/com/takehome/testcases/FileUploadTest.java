package com.takehome.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;

import com.takehome.pages.FileUpload;

public class FileUploadTest {
	DriverScript driverSetup;
	FileUpload page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}
@Test
public void fileupload()
{
	page = new FileUpload(driverSetup.getDriver(), driverSetup.getBaseURL());
	
	
	String homeDirectory = FileUtils.getUserDirectoryPath();//User Directory path
    File downloadDirectory = new File(homeDirectory,"Downloads");//download path
    
    String filename = "some-file.txt";
    File fileupload = new File(downloadDirectory,filename);//full path to upload 
    page.getFileInput().sendKeys(fileupload.getAbsolutePath());
    page.getUploadButton().click();
   Assert.assertEquals(page.getAfterUploadDisplay().getText(),filename);
   
}
	
	
	
	
	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}
}
