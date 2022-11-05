package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.TC_15_JavaScriptAlert_Page;

import static utilities.Driver.driver;

public class TC_15_JavaScriptAlert_StepDefinitions {
    TC_15_JavaScriptAlert_Page javaScriptAlertPage=new TC_15_JavaScriptAlert_Page();
    @Given("User goes to the alert page")
    public void user_goes_to_the_alert_page() {
    javaScriptAlertPage.JavaScriptLink.click();
    }
    @When("User clicks on JS Alert Button alert message displayed")
    public void user_clicks_on_js_alert_button_alert_message_displayed() {
    javaScriptAlertPage.JavaScriptAlert.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(javaScriptAlertPage.ResultTextJs.isDisplayed());
    }
    @When("User clicks on JS confirm Button and clicks ok on alert")
    public void user_clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
        javaScriptAlertPage.JsConfirm.click();
        driver.switchTo().alert().accept();
    }
    @Then("Verify new alert message is displayed")
    public void new_alert_message_is_displayed() {
        Assert.assertTrue(javaScriptAlertPage.ResultTextJs.isDisplayed());
    }
    @When("User clicks on JS Prompt Button and types a message on Prompt")
    public void user_clicks_on_js_prompt_button_and_types_a_message_on_prompt() {
        javaScriptAlertPage.JsPrompt.click();
        Alert alert =driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
    }
    @Then("the alert message contains the typed message")
    public void the_alert_message_contains_the_typed_message() {
        Assert.assertEquals(javaScriptAlertPage.ResultTextJs.getText().trim(),"You entered: Hello World!".trim());
    }

}
