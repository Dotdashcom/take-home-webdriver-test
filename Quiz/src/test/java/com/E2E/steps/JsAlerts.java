package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JsAlerts {

    @Given("the user is on the homepage page for Alerts")
    public void the_user_is_on_the_homepage_page_for_Alerts() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("http://localhost:7080/javascript_alerts");

    }
    
    
    
    @When("Test Clicks on JS Alert Button")
    public void test_Clicks_on_JS_Alert_Button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
    }
    @When("Test asserts alert message")
    public void test_asserts_alert_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(TestRunner.driver.switchTo().alert().getText().contains("I am a JS Alert"));
        TestRunner.driver.switchTo().alert().accept();
    }
    @When("Test clicks on JS confirm Button and clicks ok on alert")
    public void test_clicks_on_JS_confirm_Button_and_clicks_ok_on_alert() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();

    }
    @When("Test asserts the alert message")
    public void test_asserts_the_alert_message() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.switchTo().alert().accept();
        Assert.assertEquals( "You clicked: Ok",TestRunner.driver.findElement(By.xpath("//*[@id='result']")).getText());

    }
    @When("Test clicks on JS Prompt Button and types a message on Prompt")
    public void test_clicks_on_JS_Prompt_Button_and_types_a_message_on_Prompt() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
        Alert alert = TestRunner.driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();

    }
    @Then("Test asserts that the alert message contains the typed message")
    public void test_asserts_that_the_alert_message_contains_the_typed_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals( "You entered: Hello",TestRunner.driver.findElement(By.xpath("//*[@id='result']")).getText());
    }
    
    
}
