package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T01_02_LoginPageStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + "/login");
    }

    @When("user sends corrects login credentials")
    public void user_sends_corrects_login_credentials() {
        loginPage.usernameInput.sendKeys("tomsmith");
        loginPage.passwordInput.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();
    }

    @Then("user should land to dashboard")
    public void user_should_land_to_dashboard() {
        Assert.assertEquals(ConfigurationReader.getProperty("LandingPageText"), loginPage.confirmationText.getText());
    }

    @When("user sends incorrect username credentials")
    public void user_sends_incorrect_username_credentials() {
        loginPage.usernameInput.sendKeys("tomsmith111");
        loginPage.passwordInput.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();
    }

    @Then("user should see username error message")
    public void user_should_see_username_error_message() {
        Assert.assertEquals("Your username is invalid!\n" +
                "×", loginPage.errorMessage.getText());
    }

    @When("user sends incorrect password credentials")
    public void user_sends_incorrect_password_credentials() {
        loginPage.usernameInput.sendKeys("tomsmith");
        loginPage.passwordInput.sendKeys("SuperSecretPassword@");
        loginPage.loginButton.click();
    }

    @Then("user should see password error message")
    public void user_should_see_password_error_message() {
        Assert.assertEquals("Your password is invalid!\n" +
                "×", loginPage.errorMessage.getText());
    }

}
