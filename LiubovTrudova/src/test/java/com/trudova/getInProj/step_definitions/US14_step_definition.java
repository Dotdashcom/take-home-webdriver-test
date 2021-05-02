package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.JavaScriptAlertPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class US14_step_definition {
    private JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
   private Alert alert;

    @Given("navigate to JavaScript Alerts page")
    public void navigate_to_java_script_alerts_page() {
        javaScriptAlertPage.javaScriptAlerts.click();
    }


    @Given("Clicks on JS Alert Button and accept it")
    public void clicks_on_js_alert_button_and_accept_it() {
        javaScriptAlertPage.clickForJSAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("asserts alert message is {string}")
    public void asserts_alert_message_is(String expectedMsg) {
        Assert.assertEquals(javaScriptAlertPage.resultMessage.getText(), expectedMsg);
    }


    @Given("clicks on JS confirm Button and clicks ok on alert")
    public void clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
        javaScriptAlertPage.clickForConfirmBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    @Then("asserts alert message became {string}")
    public void assertsAlertMessageBecame(String expectedMsg) {
        Assert.assertEquals(javaScriptAlertPage.resultMessage.getText(), expectedMsg);

    }


    @Given("clicks on JS Prompt Button and type a {string} on Prompt")
    public void clicks_on_js_prompt_button_and_type_a_on_prompt(String expectedMsg) {
        javaScriptAlertPage.clickForJSPrompt.click();
     Alert alert =Driver.getDriver().switchTo().alert();

     alert.sendKeys(expectedMsg);
     alert.accept();



    }

    @Then("asserts that the alert message contains the typed {string}")
    public void asserts_that_the_alert_message_contains_the_typed(String expectedMsg) {
        Assert.assertTrue(javaScriptAlertPage.resultMessage.getText().contains(expectedMsg));

    }


}
