package dockers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsError {
	   
		@Test
	    public void JsError(){			
			String url = "http://localhost:7080/javascript_error";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			List<LogEntry> logs = logEntries.filter(Level.ALL);
			for(LogEntry logsEntries : logs) {
				System.out.println(logsEntries);
			}
			driver.close();

		}
		
	

}
