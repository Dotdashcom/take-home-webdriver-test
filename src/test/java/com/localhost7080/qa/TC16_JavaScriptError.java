package com.localhost7080.qa;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class TC16_JavaScriptError {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/javascript_error");
		
		//Get the JavaScript error with manage and logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> lg = logEntries.getAll();
		//Get the first error and compare the message with the expected
		String[] msg = lg.get(0).getMessage().split("TypeError:");
		Assert.assertEquals(msg[1].trim(), "Cannot read properties of undefined (reading 'xyz')");
		
		driver.close();

	}

}
