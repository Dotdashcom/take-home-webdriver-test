package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dropdown extends BaseTest {

    @Given("I navigate to the Dropdown Page")
    public void iNavigateToTheDropdownPage() throws Exception {
        dropdownPage.navigateToDropdownPage();
    }

    @When("I select the {string}")
    public void iSelectThe(String option)throws Exception {
        dropdownPage.selectTheOption(option);
    }

    @Then("The {string} should appear as selected")
    public void theShouldAppearAsSelected(String option) {
        dropdownPage.validateTheOptionSelected(option);
    }
}

