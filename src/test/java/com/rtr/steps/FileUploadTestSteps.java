package com.rtr.steps;

import org.junit.Assert;
import org.openqa.selenium.interactions.SendKeysAction;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FileUploadTestSteps extends CommonMethods {

	@Given("I navigated to File Upload website")
	public void i_navigated_to_file_upload_website() {
		setUp("/upload");
	}

	@Then("I test uses Upload Button")
	public void i_test_uses_upload_button() {
		
		fileupload.cfbutton.sendKeys("C:\\Users\\Necip Sercan Ozaydin\\Downloads\\some-file.txt");
		click(fileupload.uploadButton);

	}

	@Then("I assert that the file is uploaded.")
	public void i_assert_that_the_file_is_uploaded() {
		
		String expected = "File Uploaded!";
		String actual = fileupload.succesmsg.getText();
		Assert.assertEquals(expected, actual);
	}

}
