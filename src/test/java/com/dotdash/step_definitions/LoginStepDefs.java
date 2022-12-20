package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import com.dotdash.utilities.Driver;
import com.dotdash.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefs extends BaseStep{
    @Given("I am on the {word} page")
    public void i_am_on_the_login_page(String page) {
        String url = Environment.getProperty("url")+ "/"+ page;
        Driver.getDriver().get(url);
    }
    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        BrowserUtils.waitForClickability(pages.loginPage().userName, 5);
        pages.loginPage().login(username, password);
    }
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() {
        BrowserUtils.waitForVisibility(pages.securepage().flashMessages, 5);
        String actual = pages.securepage().flashMessages.getText().trim();
//        Assert.assertEquals("You logged into a secure area!", actual);
        assertThat(actual, containsString("You logged into a secure area!")  );

    }
    @When("I login with invalid credentials")
    public void i_login_with_invalid_credentials() {
        String username = "mehmet";
        String password = "akif!";
        BrowserUtils.waitForClickability(pages.loginPage().userName, 5);
        pages.loginPage().login(username, password);
    }
    @Then("I should not be able to login")
    public void i_should_not_be_able_to_login() {
        BrowserUtils.waitForVisibility(pages.securepage().flashMessages, 5);
        String actual = pages.loginPage().flashMessages.getText().trim();
        assertThat(actual, containsString(" is invalid!")  );

    }
}
