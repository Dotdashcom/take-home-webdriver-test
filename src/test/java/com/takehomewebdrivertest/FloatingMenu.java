package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FloatingMenu extends BaseTest {

    @Given("I navigate to the Floating Menu Page")
    public void iNavigateToTheFloatingMenuPage() throws Exception {
        floatingMenuPage.navigateToFloatingMenuPage();
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String floatingMenu) throws Exception {
        floatingMenuPage.clickOnButton(floatingMenu);
    }

    @Then("The URL should change {string}")
    public void theURLShouldChange(String floatingMenu) throws Exception {
        floatingMenuPage.validateUrlChange(floatingMenu);
    }

}

