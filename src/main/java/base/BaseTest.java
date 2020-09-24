package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=WebDriverInstance.getInstanceOfWebDriver();
	}
	@AfterMethod
	public void tearDown() {
		WebDriverInstance.Quit();
	}

}
