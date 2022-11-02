package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Download extends BaseTest {

    @Given("I navigate to the Download Page")
    public void iNavigateToTheDownloadPage() throws Exception {
        downloadPage.navigateToDownloadPage();
    }

    @When("I click on the download button")
    public void iClickOnTheDownloadButton() throws Exception {
        downloadPage.clickOnDownloadBtn();
    }

    @Then("The file should be downloaded")
    public void theFileShouldBeDownloaded() {
        downloadPage.verifyFileDownloaded();
    }
}

