import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptErrors {
	
	@Test	
	public void JSErrors() {

		/*
		WebDriverManager.firefoxdriver().setup();;
		WebDriver driver = new FirefoxDriver();
		*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:7080/javascript_error");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	

	    Set <String> logType = driver.manage().logs().getAvailableLogTypes();
	    
	    //this will read all the availabale logTypes
	    for (String string : logType) {
	    	System.out.println(string); 
	    	
	    }
	    
	    //I will get the all available logs
	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    List<LogEntry> logs = logEntries.filter(Level.SEVERE);
	    
	    for (LogEntry logEntry: logs) {
	    	System.out.println(logEntry);
	    }
	
	
	
	}
}
