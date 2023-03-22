package com.QA.testSteps;

import com.QA.BaseUtils.CommonMethods;
import com.QA.BaseUtils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsFileUpload extends CommonMethods {
	
	@Given("choose a file and click upload button to upload a file")
	public void choose_a_file_and_click_upload_button_to_upload_a_file() {
	  sendText(fileUpload.chooseFileToUpload, Constants.DOWNLOAD_DIR+"/some-file.txt");
	  click(fileUpload.uploadBtn);
	}

	@Then("verify that the file is uploaded")
	public void verify_that_the_file_is_uploaded() {
	    waitForVisibility(fileUpload.nameOfUploadedFile);
	    AA_Hooks.softAssert.assertTrue(fileUpload.messageHeader.getText().contains("File Uploaded!"));
	    AA_Hooks.softAssert.assertEquals(fileUpload.nameOfUploadedFile.getText(), "some-file.txt");
	}

}
