package com.anaris.step_defs;

import com.anaris.pages.BasePage;
import com.anaris.pages.LoginPage;
import com.anaris.utilities.ConfigurationReader;
import com.anaris.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("User on the login page")
    public void user_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("User enter credentials")
    public void user_enter_credentials() {

        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

    }

    @Then("User should see success message - {string}")
    public void userShouldSeeSuccessMessage(String expectedMsg) {

        String actualMsg = loginPage.actualLoggedMsg.getText().replace('×',' ').trim();

        Assert.assertEquals("Failed",expectedMsg,actualMsg);
    }

    @When("User enter {string} and {string}")
    public void userEnterAnd(String username, String password) {

        loginPage.login(username,password);
    }


    @Then("User should see failure message - {string}")
    public void userShouldSeeFailureMessage(String expectedMsg) {

        String actualMsg = loginPage.actualLoggedMsg.getText().replace('×',' ').trim();

        Assert.assertEquals("Failed",expectedMsg,actualMsg);

    }



}
