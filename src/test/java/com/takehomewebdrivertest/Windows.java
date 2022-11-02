package com.takehomewebdrivertest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Windows extends BaseTest {

    @Given("I navigate to the Windows Page")
    public void iNavigateToTheWindowsPage() throws Exception {
        windowsPage.navigateToWindowsPage();
    }

    @When("I click on the link")
    public void iClickOnTheLink() throws Exception {
        windowsPage.clickOnLink();
    }

    @Then("A new tab should appear")
    public void aNewTabShouldAppear() {
        windowsPage.navigateToSecondTab();
    }

    @And("The {string} should appear")
    public void theShouldAppear(String message) throws Exception {
        windowsPage.validateSecondTabMessage(message);
    }
}

