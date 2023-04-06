package com.internet.stepdefinitions;

import com.internet.pages.CheckboxPage;
import com.internet.utilities.ConfigurationReader;
import com.internet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckboxStepDefinitions {

    CheckboxPage checkboxPage = new CheckboxPage();




    @Given("User is on Landing page")
    public void user_is_on_landing_page() {
        Driver.getDriver("chrome").get(ConfigurationReader.getProperty("baseUrl"));
    }
    @Given("User clicks on {string} submenu")
    public void user_clicks_on_submenu(String subMenu) {
        checkboxPage.navigateByLink(subMenu);
    }

    @When("User clicks on first checkbox")
    public void user_clicks_on_first_checkbox() {
        checkboxPage.clickCheckbox1();
    }
    @Then("User observes that first checkbox is selected")
    public void user_observes_that_first_checkbox_is_selected() {
       Assertions.assertTrue(checkboxPage.ifCheckboxSelected(1));
    }
    @When("User clicks on second checkbox")
    public void user_clicks_on_second_checkbox(){
        checkboxPage.clickCheckbox2();
    }
    @Then("User observes that second checkbox is unselected")
    public void user_observes_that_second_checkbox_is_unselected() {
        Assertions.assertFalse(checkboxPage.ifCheckboxSelected(2));
    }



}
