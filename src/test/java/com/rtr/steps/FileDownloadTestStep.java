package com.rtr.steps;

import java.io.File;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FileDownloadTestStep extends CommonMethods{


@Given("I navigated to File Download website")
public void i_navigated_to_file_download_website() {
	setUp("/download");
}

@Then("I clicks on the file")
public void i_clicks_on_the_file() {
    click(filedownload.downloadlink);
}

@Then("I asserts that the file is downloaded.")
public void i_asserts_that_the_file_is_downloaded() {
   
	File fileLocation = new File("C:\\Users\\Necip Sercan Ozaydin\\Downloads");
	File[] totalFiles = fileLocation.listFiles();
	
	for(File file : totalFiles) {
		
		if(file.getName().equals("some-file")) {
			System.out.println("Test PASSED");
		}else {
			System.out.println("Test FAILED");
		}
	}
	
}
}
