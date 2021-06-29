package module;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class JavaScriptError {
	private WebDriver driver = null;
	
	public JavaScriptError(WebDriver driver) {
		this.driver = driver;
		this.loadPage();	
	}
	
	public List<String> getLogEntryMessages() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		
		// Store a copy of only the messages, since that's interesting
		List<String> messages = new ArrayList<String>();
		for( LogEntry entry : logEntries ) {
			messages.add(entry.getMessage());
		}
		
		return messages;
	}	

	public void loadPage() {
		PageLoader.loadPage(driver, "/javascript_error");		
	}	
}
