package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_01_LoginSuccess_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_LoginSuccess_StepDefinitions {
    TC_01_LoginSuccess_Page loginPage=new TC_01_LoginSuccess_Page();
    @When("User goes to login page")
    public void user_goes_to_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("loginUrl"));
    }
    @Then("User enters correct username-password")
    public void user_enters_correct_username_password() {
    loginPage.userName.sendKeys(ConfigReader.getProperty("username"));
    loginPage.Password.sendKeys(ConfigReader.getProperty("password"));
    }
    @Then("User clicks on login")
    public void user_clicks_on_login() {
    loginPage.clickButton.click();
    }
    @Then("logged in successfully")
    public void logged_in_successfully() {
        Assert.assertTrue(loginPage.loggedMassage.isDisplayed());
    }

}
