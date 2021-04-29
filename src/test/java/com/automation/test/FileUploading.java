package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DynamicLoadingPage;
import com.automation.pageobject.FileUploadPage;

public class FileUploading extends BaseTest {

	@Test
	public void FileUpLoadingTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FileUploadPage.validateFileUploadHeader(driver);
		FileUploadPage.FileUploadAndValidation(driver,"Capture.png");
		FileUploadPage.validateFileUploaded(driver,"Capture.png");
		
		
	}
}
