package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogIn {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/login");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void LogInTest() {
		PageObject driver1=new PageObject(driver);
		String username2=driver1.username2();
		String password2=driver1.Password2();
		driver1.UserName().sendKeys(username2);
		driver1.Password().sendKeys(password2);
		driver1.LogInButton().click();
		String AuthMessage = driver1.text();
		assertEquals(AuthMessage, "Welcome to the Secure Area. When you are done click logout below.");
		driver1.LogOutButton().click();
		driver.close();
	}

}
