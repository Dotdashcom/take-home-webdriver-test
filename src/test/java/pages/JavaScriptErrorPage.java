package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class JavaScriptErrorPage {

	WebDriver driver;

	public JavaScriptErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean findErrors(String errorMessage) {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

		for (LogEntry entry : logEntries) {
			if (entry.getMessage().contains(errorMessage)) {
				return true;
			}
		}
		return false;
	}

	// get url
	public JavaScriptErrorPage getUrl() {
		driver.navigate().to(TestBase.url + "/javascript_error");
		return this;
	}
}
