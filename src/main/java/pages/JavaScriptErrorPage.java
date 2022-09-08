package pages;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptErrorPage {
	static WebDriver driver;

	public JavaScriptErrorPage(WebDriver driver) {
		JavaScriptErrorPage.driver = driver;
	}

//	Methods
	public void findingJavaScriptError() {
		System.out.println("Unable to get test to find error but below the syso statement is committed code on the script which is the work I did to give the viewers a look of what I was doing.");
	      
//		-----------------Committed Code----------------------
		
//		Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
//	      for (String s : logtyp) {
//	         System.out.println(logtyp);
//	      }
//	      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//	      List<LogEntry> lg = logEntries.filter(Level.ALL);
//	      for(LogEntry logEntry : lg) {
//	         System.out.println(logEntry);
//	      }
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatesErrorCannotReadPropertyIsPresent() {
		System.out.println("Could not get the test to find the error on the page so I was unable to complete this step");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
