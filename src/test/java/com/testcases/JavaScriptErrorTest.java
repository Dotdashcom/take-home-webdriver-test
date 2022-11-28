package com.testcases;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.ArrayList;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class JavaScriptErrorTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("JavaScriptErrorURL"));
	}

	@Test(priority = 2)
	public void javaScriptErrorTest() throws Exception {

		Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
	      for (String s : logtyp) {
	         System.out.println(logtyp);
	      }
	      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	      for(LogEntry l : logEntries) {
	          System.out.println(l);
	          break;
	       }   

	}

	@AfterTest
	public void tearDown() {
		driver.quit();//quit browser
	}

}
