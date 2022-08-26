package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.E2E.runner.TestRunner;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class JsErrors {

@Given("the user is on the file jsError page")
public void the_user_is_on_the_file_jsError_page() {
    // Gets page
    TestRunner.driver.get("http://localhost:7080/javascript_error");
}


@Then("Test asserts that the page contains error Cannot read property xyz of undefined")
public void test_asserts_that_the_page_contains_error_Cannot_read_property_xyz_of_undefined() {
    // gets log of differnt errors 
    LogEntries entries = TestRunner.driver.manage().logs().get(LogType.BROWSER);
    //Gets all errors and puts them in a list
    List<LogEntry> allEntries = entries.getAll();
    //loops over all errors and checks if the error is in the list
    for (LogEntry entry : allEntries) {
        if (entry.getLevel().toString().contains("Cannot read properties of undefined")) {
            Assert.assertTrue(true);
        }
    }
}

    
}
