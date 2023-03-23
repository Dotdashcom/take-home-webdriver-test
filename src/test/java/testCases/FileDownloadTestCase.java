package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.FileDownloadPage;

public class FileDownloadTestCase extends BaseClass{
	public FileDownloadPage fileDownloadPage;
	public FileDownloadTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlFileDownload");
		fileDownloadPage = new FileDownloadPage();	
	}
	
	@Test
	public void fileDownload() {
		Assert.assertTrue(fileDownloadPage.downloadFile());
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
