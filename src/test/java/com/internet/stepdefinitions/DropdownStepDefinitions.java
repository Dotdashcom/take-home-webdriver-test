package com.internet.stepdefinitions;

import com.internet.pages.DropdownPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DropdownStepDefinitions {

    DropdownPage dropdownPage= new DropdownPage();

    @Given("User selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String option) {
        dropdownPage.selectOptions(option);

    }
    @Then("User verifies that {string} is selected")
    public void user_verifies_that_is_selected(String option) {
       Assertions.assertTrue(dropdownPage.checkWhichSelected(option));
    }
    @Then("User select {string} from the dropdown")
    public void user_select_from_the_dropdown(String option2) {
        dropdownPage.selectOptions(option2);
    }

}
