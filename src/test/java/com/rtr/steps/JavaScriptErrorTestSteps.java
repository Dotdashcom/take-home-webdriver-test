package com.rtr.steps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class JavaScriptErrorTestSteps extends CommonMethods{
	
	@Given("I navigated to JavaScript Error website")
	public void i_navigated_to_java_script_error_website() {
	    setUp("/javascript_error");
	}

	@Then("I find the js error and assert it")
	public void i_find_the_js_error_and_assert_it() {
		Set<String> errorStrings = new HashSet<>();
	    errorStrings.add("Cannot read properties of undefined (reading 'xyz')");
	    
	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    for (LogEntry logEntry : logEntries) {
	        for (String errorString : errorStrings) {
	            if (logEntry.getMessage().contains(errorString)) {
	               Assert.assertTrue(logEntry.getMessage().contains(errorString));
	            }
	        }
	    }
	}

}
