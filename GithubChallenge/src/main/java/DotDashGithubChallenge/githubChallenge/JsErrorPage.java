package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

public class JsErrorPage extends TestBase {

	public JsErrorPage(WebDriver driver) {
		super(driver);
	}
	
	//@SuppressWarnings("deprecation")
	public void verifyJsError() {
		WebDriver driver = getDriver();
		String expectedErrStr = "Cannot read property 'xyz' of undefined";
		 Logs logs = driver.manage().logs();
	        LogEntries logEntries = logs.get(LogType.BROWSER);

	        for (LogEntry entry : logEntries) {

	        	String errorLog= entry.getMessage().toString();

	        	if (errorLog.contains(expectedErrStr)) {
					assertEquals(true,errorLog.contains(expectedErrStr));
					return;
				}
	        
	        }
	           
	}

}
