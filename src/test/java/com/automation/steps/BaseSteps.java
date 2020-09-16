package com.automation.steps;

import com.automation.pages.BasePage;
import com.automation.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class BaseSteps {

    BasePage basePage = new BasePage();
    @When("I select {string} option")
    public void i_select_option(String option) {
        basePage.getOption(option).click();
    }
}
