package Testcases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.ReflectionSupport.Level;

public class TC_Jserror {
	@Test
	public void jserrortest() {
		String URL ="http://localhost:7080/javascript_error";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
	      for (String s : logtyp) {
	         System.out.println(logtyp);
	      
	      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	      List<org.openqa.selenium.logging.LogEntry> lg = logEntries.toJson();
	      for(org.openqa.selenium.logging.LogEntry logEntry : lg) {
	         System.out.println(logEntry);
	      }
	      driver.quit();
	      }
		 
	}
	
