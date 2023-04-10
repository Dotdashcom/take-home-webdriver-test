package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSErrorPage {
	WebDriver driver;

	public JSErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
