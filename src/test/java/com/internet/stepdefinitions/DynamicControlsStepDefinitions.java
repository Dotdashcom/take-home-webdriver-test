package com.internet.stepdefinitions;

import com.internet.pages.DynamicControlsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DynamicControlsStepDefinitions {

    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @When("User clicks on Remove Button")
    public void user_clicks_on_remove_button() {
        dynamicControlsPage.clickRemoveAndAddButton();
    }
    @Then("User verifies that checkbox is gone")
    public void user_verifies_that_checkbox_is_gone() {
        Assertions.assertFalse(dynamicControlsPage.checkIfCheckbox());
    }

    @Then("User verifies that checkbox came back")
    public void user_verifies_that_checkbox_came_back() {
        Assertions.assertTrue(dynamicControlsPage.checkIfCheckbox());
    }
    @Then("User clicks on the Enable Button and uses explicit wait.")
    public void user_clicks_on_the_enable_button_and_uses_explicit_wait() {
        dynamicControlsPage.clickEnableAndDisableButton();
    }
    @Then("User verifies that the text box is enabled.")
    public void user_verifies_that_the_text_box_is_enabled() throws InterruptedException {
        Assertions.assertTrue(dynamicControlsPage.checkIfFieldIsEnabled());
    }
    @Then("clicks on the Disable Button and uses explicit wait.")
    public void clicks_on_the_disable_button_and_uses_explicit_wait() {
        dynamicControlsPage.clickEnableAndDisableButton();
    }

    @Then("User verifies that the text box is disabled.")
    public void userVerifiesThatTheTextBoxIsDisabled() throws InterruptedException {
        Assertions.assertFalse(dynamicControlsPage.checkIfFieldIsEnabled());
    }

    @And("User clicks on {string} Button")
    public void userClicksOnButton(String addOrRemove) {
        dynamicControlsPage.clickRemoveAndAddButton();
    }
}
