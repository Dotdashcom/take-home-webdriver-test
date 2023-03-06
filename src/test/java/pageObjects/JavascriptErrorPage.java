package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavascriptErrorPage extends BaseTemplate{

	public JavascriptErrorPage(WebDriver driver) {
		super(driver);
	}
	
	public String getErrorMessage() {
	 StringBuilder message = new StringBuilder();
	    LogEntries log = driver.manage().logs().get(LogType.BROWSER);
	    for (LogEntry entry : log) {
	      message.append(entry.getMessage());
	    }
	    return message.toString();
	  }
}


