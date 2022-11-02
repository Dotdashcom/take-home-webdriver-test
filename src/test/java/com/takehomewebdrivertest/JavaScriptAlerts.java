package com.takehomewebdrivertest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JavaScriptAlerts extends BaseTest {

    @Given("I navigate to the JavaScript Alerts Page")
    public void iNavigateToTheJavaScriptAlertsPage() throws Exception {
        javaScriptAlertsPage.navigateToJavaScriptAlertsPage();
    }

    @When("I click on the JS Alert")
    public void iClickOnTheJSAlert() throws Exception {
        javaScriptAlertsPage.clickOnJSAlert();
    }

    @Then("An alert should appear {string}")
    public void anAlertShouldAppear(String alert) {
        javaScriptAlertsPage.validateAlertPresence(alert);
    }

    @And("I should click OK")
    public void iShouldClickOK() {
        javaScriptAlertsPage.clickOkOnAlert();
    }

    @And("the result should change to {string}")
    public void theResultShouldChangeTo(String result) {
        javaScriptAlertsPage.verifyResult(result);
    }

    @When("I click on the JS Confirm")
    public void iClickOnTheJSConfirm() throws Exception {
        javaScriptAlertsPage.clickOnJSConfirm();
    }

    @And("I should click {string}")
    public void iShouldClick(String button) {
        javaScriptAlertsPage.clickOnAlertBtn(button);
    }

    @When("I click on the JS Prompt")
    public void iClickOnTheJSPrompt() throws Exception {
        javaScriptAlertsPage.clickOnJSPrompt();
    }

    @And("I should write some {string}")
    public void iShouldWriteSome(String text) {
        javaScriptAlertsPage.writeTextOnAlert(text);
    }
}

