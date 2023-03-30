package testCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.OpenNewWindowPage;


public class OpenNewWindowTest
{
	WebDriver driver;
	OpenNewWindowPage  openNewWindowPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		openNewWindowPage = new OpenNewWindowPage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@Test
	public void newTabTest()
	{
		driver.get("http://localhost:7080/windows");
		openNewWindowPage.clickTheLink();
		String oldTab = driver.getWindowHandle();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		assertEquals(openNewWindowPage.getNewWindowMessage(), "New Window");
	}
	
}
