package com.internet.stepdefinitions;

import com.internet.pages.JavaScriptAlertsPage;
import com.internet.pages.JavaScriptErrorPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class JavaScriptStepDefinitions {

    JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
    JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();

    @When("User clicks on JS Alert Button")
    public void user_clicks_on_js_alert_button() {
        javaScriptAlertsPage.clickJsAlert();
    }
    @When("User clicks on JS Confirm Button")
    public void user_clicks_on_js_confirm_button() {
        javaScriptAlertsPage.clickJsConfirm();
    }

    @When("User clicks on JS prompt Button")
    public void user_clicks_on_js_prompt_button() {
        javaScriptAlertsPage.clickJsPrompt();
    }

    @Then("User verifies that entered text is in result")
    public void user_verifies_that_entered_text_is_in_result() {
        Assertions.assertEquals("Hello World",javaScriptAlertsPage.getPromptText());
    }

    @Then("User observes that alert popup is displayed with the message {string}")
    public void userObservesThatAlertPopupIsDisplayedWithTheMessage(String message){
        Assertions.assertTrue(javaScriptAlertsPage.ifAlertMessageDisplayed(message));
    }

    @Then("User text into prompt {string}")
    public void userTextIntoPrompt(String intro) {
        javaScriptAlertsPage.writeToPrompt(intro);
    }

    @Then("User verifies that there is JS error on the page {string}")
    public void userVerifiesThatThereIsJSErrorOnThePage(String message) {
       Assertions.assertTrue(javaScriptErrorPage.ifJSErrorExists(message));
    }
}
