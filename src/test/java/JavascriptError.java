

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavascriptError {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("  http://localhost:7080/javascript_error ");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void error() {
		boolean errorFound = false;
		for(LogEntry log : driver.manage().logs().get(LogType.BROWSER)) {
			if (log.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
				errorFound = true;
				break;
			}
		}
		assert errorFound;
	}

}
