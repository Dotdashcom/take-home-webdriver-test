package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.fileUploadPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class FileUploadTest {

	Baseclass bs;
	fileUploadPage fup;
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
		bs.launchApplication("/upload");
		fup = new fileUploadPage(bs);
	}

	/*
	 * Verify File Upload
	 */
	@Test
	public void verifyFileUpload() 
	{
		
		fup.uploadFile("./configureFile");
		Assert.assertEquals(fup.getUploadText(),"File Uploaded!");
	}
	
	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
