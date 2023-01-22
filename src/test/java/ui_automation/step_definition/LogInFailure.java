package ui_automation.step_definition;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.LogInPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LogInFailure {

    WebDriver driver = Driver.getDriver();
    LogInPage logInPage = new LogInPage(driver);

    Hooks hooks = new Hooks();

    @Before
    public void setUp(){
        hooks.setUp();
    }

    @Given("user enter invalid {string} username and {string} password then click on login Button")
    public void user_enter_invalid_username_and_password_then_click_on_login_Button(String username, String password) {
        String logInURL = (ConfigurationReder.getProperties("ui-config.properties", "LogInURL"));
        driver.get(logInURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage.LogIn(username, password);
    }

    @Then("user should be able to verify {string} error message")
    public void user_should_be_able_to_verify_error_message(String expErrorMessage) {
        String actualErrorMessage = logInPage.errorMessage.getText().substring(0,25);
        System.out.println("Sctual error message: " + actualErrorMessage);
        Assert.assertEquals(expErrorMessage, actualErrorMessage);

    }


    @After
    public void tearDown(){
        hooks.tearDown();
    }



}
