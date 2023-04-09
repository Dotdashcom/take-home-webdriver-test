package com.internet.stepdefinitions;

import com.internet.pages.FileUploadPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FileUploadStepDefinitions {

    FileUploadPage fileUploadPage = new FileUploadPage();
    @When("User select file to be uploaded")
    public void user_select_file_to_be_uploaded() {
        fileUploadPage.chooseFileTobeUploaded();
        fileUploadPage.clickUpload();
    }
    @Then("User verifies that file is uploaded")
    public void user_verifies_that_file_is_uploaded() {
        Assertions.assertTrue(fileUploadPage.ifMessageAppreared());
    }

}
