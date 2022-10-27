package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.fileDownloadPage;
import pageObjects.fileUploadPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class FileDownloadTest {

	Baseclass bs;
	fileDownloadPage fdp;
	@BeforeClass
	public void prereqsteps()
	{
		bs = new Baseclass();
		bs.generateExecutionId();
		bs.createResultsLocation();
	}
	@BeforeMethod
	public void launchAPP() 
	{
		bs.launchApplication("/download");
		fdp = new fileDownloadPage(bs);
	}

	/*
	 * Verify File Download
	 */
	@Test
	public void verifyFileDownload() 
	{
		fdp.downloadFile();
		Assert.assertEquals(fdp.verifyFileDownload(),true);
	}
	
	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
