package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.NotificationRenderPage;

public class NotificationRenderTest
{
	WebDriver driver;
	NotificationRenderPage notificationRenderPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		notificationRenderPage = new NotificationRenderPage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void flashedMessageTest()
	{
		notificationRenderPage.clickTheLink();
		Boolean result = notificationRenderPage.getTheFlashMessage().contains("Action unsuccesful, please try again")
						|| notificationRenderPage.getTheFlashMessage().contains("Action successful");
		assertTrue(result);
	}
	
}
