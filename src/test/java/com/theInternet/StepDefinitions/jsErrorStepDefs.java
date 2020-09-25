package com.theInternet.StepDefinitions;

import com.theInternet.Pages.jsErrorPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static org.junit.Assert.assertTrue;

public class jsErrorStepDefs {

    jsErrorPage jsErrorPage = new jsErrorPage();
    String message;

    @Given("User on JS Error page")
    public void user_on_JS_Error_page() {
        System.out.println("Opening the JS Error page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"javascript_error");
    }

    @When("User finds the JavaScript error on the page")
    public void user_finds_the_JavaScript_error_on_the_page() {
        LogEntries logEntries = Driver.get().manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries){
            message = entry.getMessage();
        }
    }

    @Then("assert that the page contains error: {string}.")
    public void assert_that_the_page_contains_error(String string) {
        assertTrue(message.contains(string));
    }

}
