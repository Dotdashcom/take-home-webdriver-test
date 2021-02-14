package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.logging.*;

public class JavaScriptErrorPage extends BaseDriver{
	public JavaScriptErrorPage(WebDriver driver){
        super(driver);
    }
	
	public boolean containsJsError(String errorText) {
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : entries) {
            String message = entry.getMessage().trim();
            if (message.contains(errorText)) {
                return true;
            }
        }
		return false;
	}
}
