package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.FileUploadPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class FileUploadDef extends TestBase {

	@Given("User launches the file uploader page")
	public void user_launches_the_fileuploader() {
        TestBase tb= new TestBase();
        String addPath="upload";
        tb.setupdownload(addPath);	
	}   
	 @And("user upload the file")
	 public void fileupload() {
		 FileUploadPOM fu= new FileUploadPOM();
		 fu.userfileupload();
	 }
	 @And("user verify the file is uploaded")
	 public void verifyFileUpload() {
		 FileUploadPOM fu= new FileUploadPOM();
		 fu.userverifyFileUpload(); 
	 }
	 

}
