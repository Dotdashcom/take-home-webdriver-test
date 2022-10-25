package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.UI_Util;

public class T16_JavaScriptErrorStepDefs {

    @Given("user is on the {string} JS Error page")
    public void user_is_on_the_js_error_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }
    @When("user finds error on the page")
    public void user_finds_error_on_the_page() {

    }
    @Then("user asserts that the page contains error: {string}")
    public void user_asserts_that_the_page_contains_error(String expectedErrorMsg) {
        Assert.assertTrue("error message does not match the expected error message", UI_Util.JSLogsInfoTest(expectedErrorMsg));
    }
}
