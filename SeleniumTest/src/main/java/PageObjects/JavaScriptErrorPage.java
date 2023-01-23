package PageObjects;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class JavaScriptErrorPage extends AbstractClass {
	WebDriver driver;
	String expectedMessage = "Cannot read properties of undefined (reading 'xyz')";

	public JavaScriptErrorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getJavascriptError() {
		Set<String> errorStrings = new HashSet<>();
		errorStrings.add("SyntaxError");
		errorStrings.add("EvalError");
		errorStrings.add("ReferenceError");
		errorStrings.add("RangeError");
		errorStrings.add("TypeError");
		errorStrings.add("URIError");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			for (String errorString : errorStrings) {
				if (logEntry.getMessage().contains(errorString)) {
					System.out.println(logEntry.getMessage());
					String actualMessage = logEntry.getMessage();
					if (actualMessage.contains(expectedMessage))
						return true;
				}
			}
		}

		return false;

	}

}
