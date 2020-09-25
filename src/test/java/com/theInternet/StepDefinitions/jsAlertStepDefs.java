package com.theInternet.StepDefinitions;

import com.theInternet.Pages.jsAlertPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class jsAlertStepDefs {
    jsAlertPage jsAlertPage = new jsAlertPage();
    Alert alert;
    String send = "Hi how are you?";
    @Given("User on JS Alert page")
    public void user_on_JS_Alert_page() {
        System.out.println("Opening the JS Alert page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"javascript_alerts");
    }

    @When("User Clicks on JS Alert Button.")
    public void user_Clicks_on_JS_Alert_Button() {
        jsAlertPage.jsAlertButton.click();
        alert = Driver.get().switchTo().alert();
        alert.accept();
        String expMessage = "You successfuly clicked an alert";
        assertThat(expMessage, equalTo(jsAlertPage.message.getText()));
    }

    @When("clicks on JS confirm Button and clicks ok on alert.")
    public void clicks_on_JS_confirm_Button_and_clicks_ok_on_alert() {
        jsAlertPage.jsConfirmButton.click();
        alert = Driver.get().switchTo().alert();
        alert.accept();
        String expMessage = "You clicked: Ok";
        assertThat(expMessage, equalTo(jsAlertPage.message.getText()));
    }

    @When("asserts the alert message.")
    public void asserts_the_alert_message() {

    }

    @When("clicks on JS Prompt Button and types a message on Prompt.")
    public void clicks_on_JS_Prompt_Button_and_types_a_message_on_Prompt() {
        jsAlertPage.jsPromptButton.click();
        alert = Driver.get().switchTo().alert();
        alert.sendKeys(send);
        alert.accept();
    }

    @Then("the alert message contains the typed message.")
    public void the_alert_message_contains_the_typed_message() {
        assertTrue((jsAlertPage.message.getText().contains(send)));
    }
}
