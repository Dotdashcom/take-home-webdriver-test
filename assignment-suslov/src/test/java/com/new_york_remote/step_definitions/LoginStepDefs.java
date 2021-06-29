package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.LoginPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/login");
    }




    @When("user enters correct username")
    public void user_enters_correct_username() {
loginPage.usernameInputBox.sendKeys(ConfigReader.getPropertiesValue("username"));
    }
    @When("user enter correct password")
    public void user_enter_correct_password() {
loginPage.passwordInputBox.sendKeys(ConfigReader.getPropertiesValue("password"));
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
