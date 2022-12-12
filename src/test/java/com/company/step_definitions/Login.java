package com.company.step_definitions;

import com.company.pages.LoginPage;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Login {

    LoginPage loginPage = new LoginPage();


    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        loginPage.login(credentials.get("username"), credentials.get("password"));
    }

    @Given("user is on the BaseUrl login page")
    public void the_user_is_on_the_BaseUrl_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl/login"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.inputUserName.sendKeys(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("user should see url contains secure")
    public void user_should_see_url_contains_secure() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("secure"));
    }

    @Then("user should see positive message {string}")
    public void userShouldSeePositiveMessage(String arg0) {
        assertTrue("You logged into a secure area!",loginPage.validCredentials.getText().contains("secure area!"));
    }

    @Then("user should see negative username message {string}")
    public void userShouldSeeNegativeUsernameMessage(String arg0) {
        assertTrue("Your username is invalid!",loginPage.invalidUsername.getText().contains("username is invalid!"));
    }

    @Then("user should see negative password message {string}")
    public void userShouldSeeNegativePasswordMessage(String arg0) {
        assertTrue("Your password is invalid!",loginPage.invalidPassword.getText().contains("password is invalid!"));
    }
}
