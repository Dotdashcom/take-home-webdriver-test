package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.LogIn_page;
import com.trudova.getInProj.utilities.ConfigurationReader;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_step_definition {

    private LogIn_page logIn_page = new LogIn_page();

    @Given("I enter username")
    public void i_enter_username() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login.environment"));

        logIn_page.emailInput.sendKeys(ConfigurationReader.getProperty("login"));
    }

    @When("I enter password")
    public void i_enter_password() {
        logIn_page.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        logIn_page.logInButton.click();

    }

    @Then("Welcome to the Secure Area. When you are done click logout below souled be displayed")
    public void welcome_to_the_secure_area_when_you_are_done_click_logout_below_souled_be_displayed() {
        boolean actual = logIn_page.successMessage.isDisplayed();
        Assert.assertTrue(actual);
    }


    @Given("I enter username {string}")
    public void i_enter_username(String login) {
        Driver.getDriver().get(ConfigurationReader.getProperty("login.environment"));

        logIn_page.emailInput.sendKeys(login);

    }


    @When("I enter password {string}")
    public void i_enter_password(String password) {
        logIn_page.passwordInput.sendKeys(password);
    }

    @Then("error message should contain {string}")
    public void error_message_should_contain(String errorMessage) {
        String actual = logIn_page.errorMessage.getText();
        Assert.assertTrue(actual.contains(errorMessage));
    }

}
