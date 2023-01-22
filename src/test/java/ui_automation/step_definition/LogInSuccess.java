package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.LogInPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LogInSuccess {

    WebDriver driver = Driver.getDriver();
    LogInPage logInPage = new LogInPage(driver);


    @Given("User Navigate to the URL")
    public void user_Navigate_to_the_URL() {
        String logInURL = (ConfigurationReder.getProperties("ui-config.properties", "LogInURL"));
        driver.get(logInURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Then("User enter valid userName {string} and password {string} and click on the LogIn Button")
    public void user_enter_valid_userName_and_password_and_click_on_the_LogIn_Button(String username, String password) throws InterruptedException {
        logInPage.LogIn(username, password);
        String expectedMsg = "You logged into a secure area!";
        String reallMsg = logInPage.actualSuccessMessage.getText().replace("×","").trim();
        System.out.println(expectedMsg);
        System.out.println(reallMsg);
        Assert.assertEquals(expectedMsg,reallMsg);

    }

    @After
    public void tearrDown(){
        Driver.closeDriver();
    }




}
