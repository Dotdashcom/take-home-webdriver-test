package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptError {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/javascript_error");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test

	public void JavaScriptErrorTest() {

		String ExpectedErrorr = "Cannot read property 'xyz' of undefined";
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry error : logs) {

			assertTrue(error.getMessage().contains(ExpectedErrorr));
//   System.out.println(error.getMessage());
			break;
		}

	}
}
