package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_02_LoginFailure_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_02_Login_Failure_StepDefinitions {
    TC_02_LoginFailure_Page loginFailurePage=new TC_02_LoginFailure_Page();

    @When("User goes to the login page")
    public void userGoesToTheLoginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("loginUrl"));
    }

    @When("user enters wrong username-password")
    public void user_enters_wrong_username_password() {
        loginFailurePage.userNameWrong.sendKeys(ConfigReader.getProperty("usernameWrong"));
        loginFailurePage.passwordWrong.sendKeys(ConfigReader.getProperty("passwordWrong"));
    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
    loginFailurePage.clickButtonWrong.click();
    }
    @Then("failed login")
    public void failed_login() {
    Assert.assertTrue(loginFailurePage.failMessage.isDisplayed());
    }



}
