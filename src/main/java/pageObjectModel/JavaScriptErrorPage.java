package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage {
	private WebDriver driver;

	public JavaScriptErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LogEntries checkLogs() {
		return driver.manage().logs().get("browser");
	}

}
