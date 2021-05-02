package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.FileUploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US10_step_definition {
    private FileUploadPage fileUploadPage = new FileUploadPage();

    @Given("navigate to File Upload")
    public void navigate_to_file_upload() {
        fileUploadPage.fileUpload.click();
    }

    @When("upload the file")
    public void upload_the_file() {
        fileUploadPage.fileInput.sendKeys("/Users/liubovtrudova/Desktop/eCertificate.pdf");
    }

    @Then("verify File Uploaded! is displayed")
    public void verify_file_uploaded_is_displayed() {
        Assert.assertTrue(fileUploadPage.successMsg.isDisplayed());
    }

}
