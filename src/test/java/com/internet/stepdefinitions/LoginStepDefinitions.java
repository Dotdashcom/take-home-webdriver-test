package com.internet.stepdefinitions;

import com.internet.pages.LoginPage;
import com.internet.utilities.ConfigurationReader;
import com.internet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("User is on Login Portal")
    public void user_is_on_login_portal() {
        Driver.getDriver(ConfigurationReader.getProperty("browser")).get(ConfigurationReader.getProperty("baseUrl")+"/login");   //readme specifies not to modify baseUrl
    }
    @When("User enters valid credentials")
    public void user_enters_valid_credentials(){
        loginPage.pageLogin();
    }

    @Then("User is able to login and see the message {string} with an ability to dissmiss the message by clicking {string}")
    public void userIsAbleToLoginAndSeeTheMessageWithAnAbilityToDissmissTheMessageByClicking(String str, String closeStr) {
        Assertions.assertEquals(loginPage.displayedFlashMessage(),str+"\n"+closeStr);
    }

    @And("User enters invalid credentials as {string} and {string}")
    public void userEntersInvalidCredentialsAsAnd(String username, String password) {
        loginPage.pageLogin(username,password);
    }


    @Then("User is should not be able to login and see the message {string} with an ability to dissmiss the message by clicking {string}")
    public void userIsShouldNotBeAbleToLoginAndSeeTheMessageWithAnAbilityToDissmissTheMessageByClicking(String message, String close) {
        Assertions.assertEquals(loginPage.displayedFlashMessage(),message+"\n"+close);
    }
}
