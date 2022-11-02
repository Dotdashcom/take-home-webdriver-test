package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HoverMouse extends BaseTest {

    @Given("I navigate to the Hover Mouse Page")
    public void iNavigateToTheHoverMousePage() throws Exception {
        hoverMousePage.navigateToHoverMousePage();
    }

    @When("I hover the mouse over the {string}")
    public void iHoverTheMouseOverThe(String box) throws Exception {
        hoverMousePage.hoverMouseOverBox(box);
    }

    @Then("Additional information should appear")
    public void additionalInformationShouldAppear() {
        hoverMousePage.validateAdditionalInformation();
    }
}

