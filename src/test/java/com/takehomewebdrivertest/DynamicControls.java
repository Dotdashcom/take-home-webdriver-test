package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicControls extends BaseTest {

    @Given("I navigate to the Dynamic Controls Page")
    public void iNavigateToTheDynamicControlsPage() throws Exception {
        dynamicControlsPage.navigateToDynamicControlsPage();
    }

    @When("I click on the remove button")
    public void iClickOnTheRemoveButton() throws Exception {
        dynamicControlsPage.clickOnRemoveButton();
    }

    @Then("I wait until the element is removed")
    public void iWaitUntilTheElementIsRemoved() throws Exception {
        dynamicControlsPage.waitUntilElementChange("remove");
    }

    @When("I click on the add button")
    public void iClickOnTheAddButton() throws Exception {
        dynamicControlsPage.clickOnAddButton();
    }

    @Then("I wait until the element is added")
    public void iWaitUntilTheElementIsAdded() {
        dynamicControlsPage.waitUntilElementChange("add");

    }

    @When("I click on the enable button")
    public void iClickOnTheEnableButton() throws Exception {
        dynamicControlsPage.clickOnEnableButton();

    }

    @Then("I wait until the element is enabled")
    public void iWaitUntilTheElementIsEnabled() {
        dynamicControlsPage.waitUntilElementChange("enable");

    }

    @When("I click on the disable button")
    public void iClickOnTheDisableButton() throws Exception {
        dynamicControlsPage.clickOnDisableButton();

    }

    @Then("I wait until the element is disable")
    public void iWaitUntilTheElementIsDisable() {
        dynamicControlsPage.waitUntilElementChange("disable");

    }
}

