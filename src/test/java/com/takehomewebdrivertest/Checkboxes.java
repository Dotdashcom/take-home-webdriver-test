package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkboxes extends BaseTest {

    @Given("I navigate to the Checkboxes Page")
    public void iNavigateToTheCheckboxesPage() throws Exception {
        checkboxesPage.navigateToCheckboxesPage();
    }

    @When("I click on the checkbox 1")
    public void iClickOnTheCheckbox1() throws Exception {
        checkboxesPage.clickOnCheckbox1();
    }

    @Then("It should have the checked condition")
    public void itShouldHaveTheCheckedCondition() throws Exception {
        checkboxesPage.validateThatFirstBoxIsChecked();
    }

    @When("I click on the checkbox 2")
    public void iClickOnTheCheckbox2() throws Exception {
        checkboxesPage.clickOnCheckbox2();
    }

    @Then("It should not have the checked condition")
    public void itShouldNotHaveTheCheckedCondition() throws Exception {
        checkboxesPage.validateThatSecondBoxIsChecked();
    }
}

