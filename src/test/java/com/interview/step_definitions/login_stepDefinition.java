package com.interview.step_definitions;

import com.interview.pages.LoginPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class login_stepDefinition {
LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/login");
    }




    @When("user enters correct username")
    public void user_enters_correct_username() {
loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("user enter correct password")
    public void user_enter_correct_password() {
loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @Then("logged in successfully")
    public void logged_in_successfully() {
        loginPage.loginButton.click();

        String ActualText=loginPage.loginSuccessMessage.getText();
        String ExpectedText="You logged into a secure area!";


        Assert.assertTrue(ActualText.contains(ExpectedText));






    }






    @When("user enters wrong username")
    public void user_enters_wrong_username() {
        loginPage.usernameInputBox.sendKeys("MiniBae");
    }
    @When("user enter wrong password")
    public void user_enter_wrong_password() {
        loginPage.passwordInputBox.sendKeys("Thanks1234!");
    }
    @Then("failed login")
    public void failed_login() {

        loginPage.loginButton.click();

        String ActualText=loginPage.loginFailedMessage.getText();
        String ExpectedText="Your username is invalid!";


        Assert.assertTrue(ActualText.contains(ExpectedText));




    }



}
