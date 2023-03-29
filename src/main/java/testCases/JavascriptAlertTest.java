package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.JavaScriptAlertPage;


public class JavascriptAlertTest
{
	WebDriver driver;
	JavaScriptAlertPage jsAlertPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		jsAlertPage= new JavaScriptAlertPage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void jsAlertBoxTextTest()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage.clickJsAlertButton();
		String alertText = driver.switchTo().alert().getText();
		assertTrue(alertText.contains("I am a JS Alert"));
	}
	@Test
	public void jsAlertBoxAlertTest()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage.clickJsAlertButton();
		driver.switchTo().alert().accept();
		assertEquals(jsAlertPage.getResult(), "You successfuly clicked an alert");
	}
	
	@Test
	public void jsConfirmBoxTextTest()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage.clickJsConfirmButton();
		String alertText = driver.switchTo().alert().getText();
		assertTrue(alertText.contains("I am a JS Confirm"));
	}
	
	@Test
	public void jsConfirmBoxTest()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage.clickJsConfirmButton();
		driver.switchTo().alert().accept();
		assertEquals(jsAlertPage.getResult(), "You clicked: Ok");
	}
	
	@Test
	public void jsPromptBoxTest()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		jsAlertPage.clickJsConfirmButton();
		driver.switchTo().alert().sendKeys("testing");
		driver.switchTo().alert().accept();
		assertEquals(jsAlertPage.getResult(), "You entered: testing");
	}
}
