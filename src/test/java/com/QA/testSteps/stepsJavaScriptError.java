package com.QA.testSteps;

import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.QA.BaseUtils.CommonMethods;

import io.cucumber.java.en.Then;

public class stepsJavaScriptError extends CommonMethods {	


	@Then("verify that the page contains error: Cannot read property {string} of undefined.")
	public void verify_that_the_page_contains_error_Cannot_read_property_of_undefined(String string) {
		
		for (LogEntry logEntry : driver.manage().logs().get(LogType.BROWSER).getAll()) {
			if (logEntry.getMessage().contains(string)) {
				AA_Hooks.softAssert.assertEquals(logEntry.getMessage(), "http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')");
			}
		} 
		
	}


}
