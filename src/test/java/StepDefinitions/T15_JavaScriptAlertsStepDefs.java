package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import PageObjects.JavaScriptAlertsPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T15_JavaScriptAlertsStepDefs {

    JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();
    Alert alert;

    @Given("user is on the {string} JS Alert page")
    public void user_is_on_the_js_alert_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }

    @When("user clicks on JS Alert Button")
    public void user_clicks_on_js_alert_button() {
        javaScriptAlertsPage.jsAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("user verifies alert message")
    public void user_verifies_alert_message() {
        Assert.assertTrue("Result text did not displayed!", javaScriptAlertsPage.resultText.isDisplayed());
        String actualResultText = javaScriptAlertsPage.resultText.getText();
        String expectedResultText = "You successfuly clicked an alert";
        Assert.assertEquals(expectedResultText,actualResultText);
    }

    @Then("user clicks on JS confirm Button and clicks ok on alert")
    public void user_clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
        javaScriptAlertsPage.confirmAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("user verifies the alert message'")
    public void user_verifies_the_alert_message() {
        Assert.assertTrue("result text did not appear!", javaScriptAlertsPage.resultText.isDisplayed());
        String actualText = javaScriptAlertsPage.resultText.getText();
        String expectedText = "You clicked: Ok";
        Assert.assertEquals(expectedText,actualText);
    }

    @Then("user clicks on JS Prompt Button and types a {string} on Prompt.")
    public void user_clicks_on_js_prompt_button_and_types_a_on_prompt(String message) {
        javaScriptAlertsPage.promptAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
    }

    @Then("user asserts that the alert message contains the typed message.")
    public void user_asserts_that_the_alert_message_contains_the_typed_message() {
        Assert.assertTrue("result text did not appear!", javaScriptAlertsPage.resultText.isDisplayed());
        String actualText = javaScriptAlertsPage.resultText.getText();
        String expectedText = "You entered: Take Home Assignment!";
        Assert.assertEquals(expectedText, actualText);
    }

}
