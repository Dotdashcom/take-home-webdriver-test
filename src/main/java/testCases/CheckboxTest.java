package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.ChceckboxPage;

public class CheckboxTest
{
	WebDriver driver;
	ChceckboxPage checkboxPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
//		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		checkboxPage = new ChceckboxPage(driver);
//		driver.get("http://localhost:7080/checkboxes");
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@BeforeMethod
	public void beforeMethod()
	{
		driver.manage().deleteAllCookies();
	}
	@Test
	public void checkOnlyFirstBox()
	{
		driver.get("http://localhost:7080/checkboxes");
		checkboxPage.setFirstCheckbox();
		assertTrue(checkboxPage.getFirstCheckbox());
	}
	@Test
	public void checkOnlySecondBox()
	{
		driver.get("http://localhost:7080/checkboxes");
		checkboxPage.setSecondCheckbox();
		System.out.println(checkboxPage.getSecondCheckbox());
		assertTrue(checkboxPage.getSecondCheckbox());
	}
	@Test
	public void checkBothBox() 
	{
		driver.get("http://localhost:7080/checkboxes");
		checkboxPage.setFirstCheckbox();
		checkboxPage.setSecondCheckbox();
		assertTrue(checkboxPage.getFirstCheckbox() && checkboxPage.getSecondCheckbox());
	}
}
