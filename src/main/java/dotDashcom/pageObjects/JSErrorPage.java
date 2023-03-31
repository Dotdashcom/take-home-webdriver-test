package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPage {
	WebDriver driver;

	public JSErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String checkJSError() {
		String resultError="null";
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry le: logEntries) {
			resultError=le.getMessage();
		}
		return resultError;
	}
}
