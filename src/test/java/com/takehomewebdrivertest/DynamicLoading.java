package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicLoading extends BaseTest {

    @Given("I navigate to the Dynamic Loading Page")
    public void iNavigateToTheDynamicLoadingPage() throws Exception {
        dynamicLoadingPage.navigateToDynamicLoadingPage();
    }

    @When("I click on the Start Button")
    public void iClickOnTheStartButton() throws Exception {
        dynamicLoadingPage.clickOnStartButton();
    }

    @Then("I wait until the text appears")
    public void iWaitUntilTheTextAppears() throws Exception {
        dynamicLoadingPage.validateText();
    }
}

