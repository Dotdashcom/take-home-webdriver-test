package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;

import pages.FileUploadPage;

public class UploadFileTestCase extends BaseClass {
	public FileUploadPage fileUploadPage;
	public UploadFileTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlFileUpload");
		fileUploadPage = new FileUploadPage();	
	}
	
	@Test
	public void uploadFile() {
		
		Assert.assertEquals(fileUploadPage.uploadFile(),true);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
