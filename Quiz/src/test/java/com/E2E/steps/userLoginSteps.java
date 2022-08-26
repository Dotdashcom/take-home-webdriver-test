package com.E2E.steps;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userLoginSteps {

    @Given("the user is on the log-in page")
    public void the_user_is_on_the_log_in_page() {
        TestRunner.driver.get("http://localhost:7080/login");
    }
    @When("the user enters correct username")
    public void the_user_enters_correct_username() {
        TestRunner.userLoginPom.usernameLoginInput("tomsmith");
    }
    @When("the user enters correct password")
    public void the_user_enters_correct_password() {
        TestRunner.userLoginPom.passcodeLoginInput("SuperSecretPassword!");
    }
    @When("the user clicks on the log-in button")
    public void the_user_clicks_on_the_log_in_button() {
        TestRunner.userLoginPom.submitLoginCorrect();
    }
    @Then("the user will be redirected to the homepage")
    public void the_user_will_be_redirected_to_the_homepage() {
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("The Internet", title);
    }

    @When("the user enters wrong username")
    public void the_user_enters_wrong_username() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.userLoginPom.usernameLoginInput("nottomsmith");

    } 
    @When("the user enters wrong password")
    public void the_user_enters_wrong_password() {
    
        TestRunner.userLoginPom.passcodeLoginInput("NotSuperSecretPassword!");
    }

    @Then("error message will be displayed")
    public void error_message_will_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.userLoginPom.errorMessageDisplayed();
    
    }

    
    

}
