package com.dotdash.stepDefinitions;

import org.testng.Assert;

import com.dotdash.pageObjects.FileDownloadPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class FileDownloadDef extends TestBase {

	
	@Given("User launches the file download page")
	public void user_launches_the_filedownload() {
        TestBase tb= new TestBase();
        String addPath="download ";
        tb.setupdownload(addPath);	
	}    
    @And("user download the file")
    public void fileDownload() {
    	FileDownloadPOM fd = new FileDownloadPOM();
    	fd.userfileDownload();
    }
    
    @And("user verify the file is downloaded")
    public void verifyfiledownload() {
    	FileDownloadPOM fd = new FileDownloadPOM();
    	boolean fileExists=fd.userverifyfiledownload();
    	Assert.assertTrue(fileExists);
    	System.out.println(fileExists);
    }
}
