/**
 * 
 */
package tests;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.List;


public class TestJavascriptError {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/javascript_error");
		
	}
	
	@Test
	public void jsErrorSuccess() {
		boolean found = false;
        String err = "Cannot read properties of undefined";
        LogEntries logEntries = this.driver.manage().logs().get(LogType.BROWSER);
        List<org.openqa.selenium.logging.LogEntry> log = logEntries.getAll();
        for(org.openqa.selenium.logging.LogEntry logEntry : log) {
            if(logEntry.toString().contains(err)) {
                found = true;
            }
        }
        assertTrue(found);
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}