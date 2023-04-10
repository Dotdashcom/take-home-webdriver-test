package navpreet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPageObjects {

	WebDriver driver;
	
	public JavaScriptErrorPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/javascript_error']")
	private WebElement click_javascriptError;
	
	public void ClickJavaScriptError()
	{
		click_javascriptError.click();
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
