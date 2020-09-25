package com.theInternet.StepDefinitions;

import com.github.javafaker.Faker;
import com.theInternet.Pages.loginPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class loginStepDefinitions1and2 {
    loginPage loginPage = new loginPage();
    Faker faker = new Faker();

    @Given("User on login page")
    public void user_on_login_page() {
        System.out.println("Opening the login page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"login");
        System.out.println(Driver.get().getTitle());
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.userNameField.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordField.sendKeys(ConfigurationReader.get("password"));
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }

    @Then("{string} should be visible")
    public void title_should_be(String message) {
        message = loginPage.message.getText();
        assertThat(message, containsString("You logged into a secure area!"));
    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String invalidUsername, String invalidPassword) {
       invalidUsername = faker.name().username();
       loginPage.userNameField.sendKeys(invalidUsername);
       invalidPassword = faker.superhero().power();
       loginPage.passwordField.sendKeys(invalidPassword);
    }

    @Then("{string} message should be visible")
    public void message_should_be_visible(String message) {
        message = loginPage.message.getText();
        assertThat(message, containsString(" is invalid"));
    }
}
