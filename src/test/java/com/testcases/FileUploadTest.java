package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.base.Base;
import com.pages.FileUploadPage;

public class FileUploadTest extends Base{
	FileUploadPage fup;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("File Upload")).click();
		fup=new FileUploadPage();
	}
	
	@Test
	public void verifyTheFileUploadloadTest() {
		fup.uploadAfile();
		fup.clickOnUploadBtn();
		Assert.assertTrue(fup.fileUploadedMessage());
		if(driver.getPageSource().contains("File Uploaded!")) {
			System.out.println("File Uploaded successfully");
		}
		else {
			System.out.println("File Not Uploaded successfully");
		}
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
