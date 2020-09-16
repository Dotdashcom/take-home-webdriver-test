package com.POM;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPage {
	public WebDriver driver;


	public JSErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}
	public void JSErrors() {

		Set <String> logType = driver.manage().logs().getAvailableLogTypes();

		//this will read all the availabale logTypes
		for (String string : logType) {
			System.out.println(string); 

		}

		//I will get the all available logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.filter(Level.ALL);

		for (LogEntry logEntry: logs) {
			System.out.println(logEntry);
		}
	}

}
