
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptError {

private ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/javascript_error");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void error() {
		boolean errorFound = false;
		for(org.openqa.selenium.logging.LogEntry log : driver.manage().logs().get(LogType.BROWSER)) {
			if (((org.openqa.selenium.logging.LogEntry) log).getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
				errorFound = true;
				break;
			}
		}
		assert errorFound;
	}
}
