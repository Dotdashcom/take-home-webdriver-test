package pages.actions;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

import base.Page;

public class JavaScripErrorPage extends Page {
	
	public void findJSError() {

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.filter(Level.ALL);
		String log = "";
		for (LogEntry logEntry : logs) {
			log += logEntry.toString();
			System.out.println(logEntry);
		}
		System.out.println(log);
		
		Assert.assertTrue(log.contains("Cannot read properties of undefined"), "can't find error message");
	}

}
