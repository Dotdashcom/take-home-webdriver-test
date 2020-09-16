package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @Given("I am on the main landing page")
    public void i_am_on_the_main_landing_page() {
        Driver.get().get(ConfigurationReader.getProperty("base_url"));
    }

    @Given("I go to login page")
    public void i_go_to_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("base_url")+"/login");
    }

    @Given("I put my username as {string} and password as {string}")
    public void i_put_my_username_as_and_password_as(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Given("I click login button")
    public void i_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify that {string} message is displayed")
    public void verify_that_message_is_displayed(String message) {
        System.out.println(loginPage.loginMessage.getText());
        Assert.assertTrue(loginPage.loginMessage.getText().contains(message));
    }
}
