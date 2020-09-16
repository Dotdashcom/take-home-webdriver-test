package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.et.Ja;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

public class JS_alert_error_Steps {

    List<WebElement> buttons = Driver.get().findElements(By.tagName("button"));
    Alert alert;

    @When("I click alert button {string}")
    public void i_click_alert_button(String button) {
        buttons.get(Integer.parseInt(button)-1).click();
    }

    @Then("assert that alert message is {string}")
    public void assert_that_alert_message_is(String message) {
        alert = Driver.get().switchTo().alert();
        Assert.assertEquals(alert.getText(), message);
        alert.accept();
    }

    @Then("I enter {string} on alert input box")
    public void i_enter_on_alert_input_box(String inputText) {
        alert.sendKeys(inputText);
        alert.accept();
    }

    @Then("assert that alert message is {string} is displayed on the page")
    public void assert_that_alert_message_is_is_displayed_on_the_page(String expectedText) {
        boolean res = Driver.get().findElement(By.id("result")).getText().contains(expectedText);
        Assert.assertTrue(res);
    }

    @Then("asserts that the page contains error: {string}")
    public void asserts_That_The_Page_Contains_Error(String err) {
        LogEntries logEntries = Driver.get().manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.ALL);

        boolean res = false;
        for (LogEntry logEntry : logs) {
            System.out.println(logEntry.getMessage());
            String message = logEntry.getMessage();
            res = res || message.contains(err);
        }

        Assert.assertTrue(res);
    }
}
