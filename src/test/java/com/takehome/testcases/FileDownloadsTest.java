package com.takehome.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.FileDownload;

public class FileDownloadsTest {
	DriverScript driverSetup;
	FileDownload page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}

	@Test
	public void filedownload() 
	{
		
		page = new FileDownload(driverSetup.getDriver(), driverSetup.getBaseURL());
	    String homeDirectory = FileUtils.getUserDirectoryPath();//User Directory path
	   
		File downloadDirectory = new File(homeDirectory, "Downloads");//forming downloads path
		String filename = page.getFileLink().getText();
		page.getFileLink().click();
		File addfilename = new File(downloadDirectory,filename);//path with file name 
		System.out.println(addfilename.getAbsolutePath());
		Assert.assertTrue(addfilename.exists());
		
		
	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}

}
