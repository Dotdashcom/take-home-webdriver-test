package PageObjects;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import Common.Config;
public class JavaScriptErrorPage extends BasePage {
	public JavaScriptErrorPage (Config testConfig) {
		super(testConfig);
	}
	public String getJsError() {
		LogEntries logEntries = testConfig.driver.manage().logs().get(LogType.BROWSER);
		String consoleLogs = "";
		for (LogEntry entry : logEntries) {
			consoleLogs = consoleLogs + entry.getMessage() + " | ";
		}
		return consoleLogs;
	}
}
