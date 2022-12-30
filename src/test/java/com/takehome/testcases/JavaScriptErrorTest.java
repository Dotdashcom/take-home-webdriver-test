package com.takehome.testcases;

import java.util.ArrayList;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.JavascriptErrorPage;

public class JavaScriptErrorTest {

	DriverScript driverSetup;
	JavascriptErrorPage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}
	
	public void javascripterror() throws InterruptedException {
		page = new JavascriptErrorPage(driverSetup.getDriver(), driverSetup.getBaseURL());
		LogEntries logs = driverSetup.getDriver().manage().logs().get(LogType.BROWSER);
		System.out.println("Print all logs" + logs.getAll());
		Thread.sleep(5000);
		System.out.println(logs.getAll().get(0).toString());
		Assert.assertTrue(
				logs.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));

	}

	@Test
	public void javascripterrorsolution2() {
		page = new JavascriptErrorPage(driverSetup.getDriver(), driverSetup.getBaseURL());
		LogEntries logsentries = driverSetup.getDriver().manage().logs().get(LogType.BROWSER);
		ArrayList<String> logmessages = new ArrayList<String>();
		boolean javascriptErrorExists = false;
		
		for (LogEntry log : logsentries) {

			logmessages.add(log.getMessage());
			System.out.println(log.getLevel().toString());
			if (log.getLevel().toString().equals("SEVERE"))

				javascriptErrorExists = true;
			Assert.assertTrue(javascriptErrorExists);// Test finds the JavaScript error on the page

		}

		// Test asserts that the page contains error: Cannot read property 'xyz' of
		// undefined

		boolean contanisspecificerrormessage = false;
		for (String message : logmessages) {
			if (message.contains("Cannot read properties of undefined (reading 'xyz')"))
				contanisspecificerrormessage = true;
			Assert.assertTrue(contanisspecificerrormessage);
		}
	

	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}
}
