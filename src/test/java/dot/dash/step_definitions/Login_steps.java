package dot.dash.step_definitions;

import dot.dash.pages.Login;
import dot.dash.utilities.ConfigReader;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_steps {

    Login login = new Login();

    @Given("user in {string} page")
    public void user_in_page(String page) {
        Driver.getDriver().get(ConfigReader.getProperty("BaseUrl") + page);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        login.Login(ConfigReader.getProperty("validUsername"), ConfigReader.getProperty("validPassword"));
    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        login.Login(ConfigReader.getProperty("invalidUsername"), ConfigReader.getProperty("invalidPassword"));
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String msg) {
        String actual = login.successMessage.getText();
        actual = actual.substring(0, actual.indexOf("!") + 1);
        Assert.assertEquals(actual, msg);
    }


}
