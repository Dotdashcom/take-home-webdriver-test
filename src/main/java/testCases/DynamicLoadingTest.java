package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.DynamicLoadingPage;


public class DynamicLoadingTest
{
	WebDriver driver;
	WebDriverWait wait;
	DynamicLoadingPage dynamicLoadingPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		dynamicLoadingPage = new DynamicLoadingPage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void dynamicMessageTest()
	{
		driver.get("http://localhost:7080/dynamic_loading/2");
		dynamicLoadingPage.clickStartButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicLoadingPage.getMessageElement()));
		assertEquals(dynamicLoadingPage.getFinishedMessage(), "Hello World!");
	}
}
