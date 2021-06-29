package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.JavaScriptAlertPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import com.new_york_remote.utilities.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class JSAlertStepDefs {
    WebDriver driver = Driver.getDriver();
    JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage();
    @Given("user is on the alert page")
    public void user_is_on_the_alert_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/javascript_alerts");
    }



    @When("user clicks on JS Alert Button alert message displayed")
    public void user_clicks_on_js_alert_button_alert_message_displayed() {

javaScriptAlertPage.jsAlert.click();
        Alert alert =Driver.getDriver().switchTo().alert();

alert.accept();

       Assert.assertTrue(javaScriptAlertPage.resultText.isDisplayed());


    }
    @When("user clicks on JS confirm Button and clicks ok on alert")
    public void user_clicks_on_js_confirm_button_and_clicks_ok_on_alert() {
javaScriptAlertPage.jsConfirm.click();

    }
    @Then("new alert message is displayed")
    public void new_alert_message_is_displayed() {
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();
        Assert.assertTrue(javaScriptAlertPage.resultText.isDisplayed());
    }
    @When("user clicks on JS Prompt Button and types a message on Prompt")
    public void user_clicks_on_js_prompt_button_and_types_a_message_on_prompt() {
javaScriptAlertPage.jsPrompt.click();
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.sendKeys("Thank you!");
        alert.accept();
        HelperMethods.waitForPageLoadComplete(driver,10);
    }
    @Then("the alert message contains the typed message")
    public void the_alert_message_contains_the_typed_message() {

Assert.assertEquals(javaScriptAlertPage.resultText.getText(),"You entered: Thank you!");
    }

}
