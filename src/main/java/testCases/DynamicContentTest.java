package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.DynamicContentPage;


public class DynamicContentTest
{
	WebDriver driver;
	DynamicContentPage dynamicContentPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		driver = new ChromeDriver(browserOptions);
		dynamicContentPage = new DynamicContentPage(driver);
		driver.get("http://localhost:7080/dynamic_content");
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testDynamicContentChange()
	{
		String beforeClick = dynamicContentPage.getChangingPara();
		dynamicContentPage.clickTheLink();
		assertTrue(!(beforeClick.equals(dynamicContentPage.getChangingPara())));
	}
	
}
