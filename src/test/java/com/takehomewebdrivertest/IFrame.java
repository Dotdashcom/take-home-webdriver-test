package com.takehomewebdrivertest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IFrame extends BaseTest {

    @Given("I navigate to the iFrame Page")
    public void iNavigateToTheIFramePage() throws Exception {
        iFramePage.navigateToIFramePage();
    }

    @When("I write into the text area")
    public void iWriteIntoTheTextArea() throws Exception {
        iFramePage.writeIntoTextArea();
    }

    @And("Apply bold, align right and change font size")
    public void applyBoldAlignRightAndChangeFontSize() throws Exception {
        iFramePage.applyBoldAlignRightAndChangeFontSize();
    }

    @And("I write into the text area again")
    public void iWriteIntoTheTextAreaAgain() throws Exception {
    }

    @Then("The changes should be made")
    public void theChangesShouldBeMade() throws Exception {
        iFramePage.verifyChanges();
    }

}

