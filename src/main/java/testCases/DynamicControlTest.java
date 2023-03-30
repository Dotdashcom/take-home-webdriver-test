package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.DynamicControlPage;


public class DynamicControlTest
{
	WebDriver driver;
	DynamicControlPage dynamicControlPage;
	WebDriverWait wait;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		dynamicControlPage = new DynamicControlPage(driver);
		driver.get("http://localhost:7080/dynamic_controls");
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@Test
	public void removeCheckBoxTest()
	{
		dynamicControlPage.clickRemoveButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		assertEquals(dynamicControlPage.getMessage(), "It's gone!");
	}
	@Test
	public void addCheckBoxTest()
	{
		dynamicControlPage.clickRemoveButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		dynamicControlPage.clickAddButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		assertEquals(dynamicControlPage.getMessage(), "It's back!");
	}
	@Test
	public void enableTextBoxTest()
	{
		driver.get("http://localhost:7080/dynamic_controls");
		dynamicControlPage.clickEnableButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		assertTrue(dynamicControlPage.isTextBoxEnabled());
	}
	@Test
	public void disableTextBoxTest()
	{
		driver.get("http://localhost:7080/dynamic_controls");
		dynamicControlPage.clickEnableButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		dynamicControlPage.clickDisableButton();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dynamicControlPage.getByMessageElement()));
		assertTrue(!dynamicControlPage.isTextBoxEnabled());
	}
}
