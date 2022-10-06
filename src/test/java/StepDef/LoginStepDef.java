package StepDef;
import Pages.AfterLoginPage;
import Pages.LoginPage;
import Util.ConfigurationReader;
import Util.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;
public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    AfterLoginPage afterLoginPage = new AfterLoginPage();
    @Given("user on login page")
    public void user_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @Given("user use valid credentials for login")
    public void user_use_valid_credentials_for_login() {
        loginPage.login.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }
    @Then("user should see page with massage about successful login")
    public void user_should_see_page_with_massage_about_successful_login() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("secure"));
        //or we can do assertion by text on page
        Assert.assertTrue(afterLoginPage.welcomeSign.getText().contains("Welcome"));
    }
    @When("user use invalid credentials for login")
    public void user_use_invalid_credentials_for_login() {
        loginPage.login.sendKeys("invalidUsername");
        loginPage.password.sendKeys("invalidPassword" + Keys.ENTER);
    }
    @Then("user should see notice about failed login")
    public void user_should_see_notice_about_failed_login() {
        Assert.assertTrue(afterLoginPage.errorFlash.getText().contains("invalid"));
    }
}