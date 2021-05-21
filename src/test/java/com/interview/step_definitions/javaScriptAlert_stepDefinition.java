package com.interview.step_definitions;

import com.interview.pages.JavaScriptAlertPage;
import com.interview.utilities.BrowserUtils;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class javaScriptAlert_stepDefinition {
    JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage();
    @Given("user is on the alert page")
    public void user_is_on_the_alert_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/javascript_alerts");
    }



    @When("user clicks on JS Alert Button alert message displayed")
    public void user_clicks_on_js_alert_button_alert_message_displayed() {

javaScriptAlertPage.JsAlert.click();
        Alert alert =Driver.getDriver().switchTo().alert();

alert.accept();

       Assert.assertTrue(javaScriptAlertPage.ResultText.isDisplayed());


    }
    @When("user clicks on JS confirm Button and clicks ok on alert")
    public void user_clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
javaScriptAlertPage.JsConfirm.click();

    }
    @Then("new alert message is displayed")
    public void new_alert_message_is_displayed() {
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();
        Assert.assertTrue(javaScriptAlertPage.ResultText.isDisplayed());
    }
    @When("user clicks on JS Prompt Button and types a message on Prompt")
    public void user_clicks_on_js_prompt_button_and_types_a_message_on_prompt() {
javaScriptAlertPage.JsPrompt.click();
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.sendKeys("Thank you!");
        alert.accept();
        BrowserUtils.sleep(2);
    }
    @Then("the alert message contains the typed message")
    public void the_alert_message_contains_the_typed_message() {

Assert.assertEquals(javaScriptAlertPage.ResultText.getText(),"You entered: Thank you!");
    }

}
