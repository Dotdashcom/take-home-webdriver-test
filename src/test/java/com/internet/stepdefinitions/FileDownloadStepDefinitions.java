package com.internet.stepdefinitions;

import com.internet.pages.FileDownloaderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FileDownloadStepDefinitions {

    FileDownloaderPage fileDownloaderPage = new FileDownloaderPage();

    @When("User clicks on link to download the file")
    public void user_clicks_on_link_to_download_the_file(){
        fileDownloaderPage.clickDownloadFile();
    }

    @Then("User verifies that file is downloaded")
    public void user_verifies_that_file_is_downloaded() {
       Assertions.assertTrue(fileDownloaderPage.checkFile("some-file.txt"));


    }


}
