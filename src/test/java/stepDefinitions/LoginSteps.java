package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import utils.PropertyKeys;
import java.time.Duration;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    public LoginSteps() throws Exception {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        loginPage = new LoginPage(driver, wait);
    }

    @Given("user navigates to Login page")
    public void navigatesTologinPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/login");
        loginPage.WaitUntilElementVisible(loginPage.loginPageHeader);
    }

    @When("^user inputs \"(.*)\" username$")
    public void inputsUsername(String validation) {
        loginPage.WaitUntilElementVisible(loginPage.usernameField);
        switch (validation) {
            case "valid":
                loginPage.usernameField.sendKeys(PropertyKeys.getProperty("username"));
                break;
            case "invalid":
                loginPage.usernameField.sendKeys("Test1234");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    @And("^user inputs \"(.*)\" password$")
    public void inputPassword(String validation) {
        loginPage.WaitUntilElementVisible(loginPage.passwordField);
        switch (validation) {
            case "valid":
                loginPage.passwordField.sendKeys(PropertyKeys.getProperty("password"));
                break;
            case "invalid":
                loginPage.passwordField.sendKeys("Abcd1234");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    @Then("user is logged in successfully")
    public void validateLoginSuccess() {
        loginPage.WaitUntilElementVisible(loginPage.loginSuccessMessage);
        Assert.assertNotNull(loginPage.loginSuccessMessage);
    }

    @Then("user is unable to login")
    public void userNotLoggedIn() {
        loginPage.WaitUntilElementVisible(loginPage.loginErrorMessage);
        Assert.assertNotNull(loginPage.loginErrorMessage);
    }

    @And("user clicks login button")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();
    }
}
