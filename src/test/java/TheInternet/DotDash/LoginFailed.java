package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFailed {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/login");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void LoginFailedTest()  {

		PageObject driver1 = new PageObject(driver);
		String UserName= driver1.username1();
		String Password= driver1.Password1();
		driver1.UserName().sendKeys(UserName);
		driver1.Password().sendKeys(Password);
		driver1.LogInButton().click();
		String errorMessage = driver1.FlashMessages();
		assertTrue(errorMessage.contains("Your username is invalid!"));
		driver.close();

	}

}
