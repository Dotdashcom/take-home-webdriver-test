package com.internet.stepdefinitions;

import com.internet.pages.DynamicControlsPage;
import com.internet.pages.DynamicLoadingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DynamicLoadingStepDefinitions {
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @When("User clicks on {string}")
    public void user_clicks_on(String string) {
        dynamicLoadingPage.navigateByTextLink(string);
    }
    @When("User clicks on Start button")
    public void user_clicks_on_start_button() {
        dynamicLoadingPage.clickStart();
    }
    @Then("User verifies that text appears")
    public void user_verifies_that_text_appears() {
        dynamicControlsPage.waitUntilLoadingIndicatorisGone();
        Assertions.assertTrue(dynamicLoadingPage.checkIfHelloWorldAppeared());
    }



}


