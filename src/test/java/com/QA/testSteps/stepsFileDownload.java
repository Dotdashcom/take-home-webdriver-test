package com.QA.testSteps;

import java.io.File;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepsFileDownload extends CommonMethods {

	int amountOfFilesBefore;

	@Given("click on the file")
	public void click_on_the_file() {
		amountOfFilesBefore = filesDownload().length;
		click(fileDownload.linkToFile);
	}

	@Then("verify that the file is downloaded")
	public void verify_that_the_file_is_downloaded() {
		//in my experience I prefer to use this method or something similar, I found it more stable
		//usually I don't look by name, only by the number of downloaded files. 
		boolean isDownloaded = false;		
		
		getWaitObjectFluent().until(x->amountOfFilesBefore < filesDownload().length);
	
			for (File file : filesDownload()) {
				if (file.getName().equals("some-file.txt")) {
					isDownloaded = true;
				}
			}			
		
		AA_Hooks.softAssert.assertTrue(isDownloaded, "File was not downloaded");
		
		
		//but this way in this case looks better
		getWaitObjectFluent().until(x->getFileObject("/some-file.txt").exists());
		AA_Hooks.softAssert.assertTrue(getFileObject("/some-file.txt").exists(), "File was not downloaded");
	}

}
