package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.MouseHoverPage;


public class MouseHoverTest
{
	WebDriver driver;
	MouseHoverPage mouseHoverPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		
		driver = new ChromeDriver(browserOptions);
		mouseHoverPage = new MouseHoverPage(driver);
		
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void checkIfTextAppearOnHover()
	{
		driver.get("http://localhost:7080/hovers");
		Actions actions= new Actions(driver);
		actions.moveToElement(mouseHoverPage.getFirstPhoto()).perform();
		assertTrue(mouseHoverPage.isUserEnabled());
	}
}
