package steps;

import base.ConfigsReader;
import base.Functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageSteps extends Functions {

    @Given("user is on the Page {string}")
    public void user_is_on_the_Page(String loginPageURL) {

        driver.get(loginPageURL);
    }

    @When("user enters valid {string} and {string} and clicks on login button")
    public void user_enters_valid_and_and_clicks_on_login_button(String username, String password) {

        login.login(username, password);

    }

    @Then("user is on {string} and see {string}")
    public void user_is_on_and_see(String secureAreaPage, String message) {

        Assert.assertEquals(secureArea.getMessage(secureArea.message),message);
        Assert.assertEquals(secureArea.getMessage(secureArea.secureAreaHeader),secureAreaPage);
    }

    @When("user enters invalid {string} and {string} and clicks on login button")
    public void user_enters_invalid_and_and_clicks_on_login_button(String username, String password) {

        login.login(username, password);
    }

    @Then("user sees {string} is displayed")
    public void user_sees_is_displayed(String message) {

        Assert.assertEquals(secureArea.getMessage(secureArea.message),message);
    }



}
