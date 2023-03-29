package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.ContextMenuPage;

public class ContextMenuTest
{
	WebDriver driver;
	ContextMenuPage contextMenu;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
//		browserOptions.setHeadless(true);
		
		driver = new ChromeDriver(browserOptions);
		contextMenu = new ContextMenuPage(driver);
		driver.get("http://localhost:7080/context_menu");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@Test
	public void alertMenuTest()
	{
		contextMenu.rightClickHotSpot();
		assertEquals(contextMenu.getAlertText(), "You selected a context menu");
	}
}
