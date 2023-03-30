package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.FloatinMenuPage;


public class FloatingMenuTest
{
	WebDriver driver;
	FloatinMenuPage floatinMenuPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		
		driver = new ChromeDriver(browserOptions);
		floatinMenuPage = new FloatinMenuPage(driver);
		
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@Test
	public void floatingMenuStayTest()
	{
		driver.get("http://localhost:7080/floating_menu");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		assertEquals(floatinMenuPage.getHeaderText(), "Floating Menu!");
	}
}
