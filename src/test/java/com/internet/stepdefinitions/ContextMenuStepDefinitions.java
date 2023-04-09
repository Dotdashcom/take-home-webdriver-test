package com.internet.stepdefinitions;

import com.internet.pages.ContextMenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class ContextMenuStepDefinitions {

    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Given("User right clicks on the box")
    public void user_right_clicks_on_the_box() throws InterruptedException {
        contextMenuPage.rightClickContext();
    }
    @Then("User observes that alert popup is displayed")
    public void user_observes_that_alert_popup_is_displayed() {
        Assertions.assertTrue(contextMenuPage.isAlertPresent());
    }




}
