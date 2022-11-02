package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseTest {

    @Given("I navigate to the Login Page")
    public void iNavigateToTheLoginPage() throws Exception {
        loginPage.navigateToLoginPage();
    }

    @When("I enter {string} and {string} as credentials")
    public void iEnterAndAsCredentials(String user, String password) throws Exception {
        loginPage.loginProcess(user, password);
    }


    @Then("I should see the success {string}")
    public void iShouldSeeTheSuccess(String message) throws Exception {
        securePage.validateMessage(message);
    }

    @Then("I should see the failed {string}")
    public void iShouldSeeTheFailed(String message) throws Exception {
        loginPage.validateMessage(message);
    }

}

