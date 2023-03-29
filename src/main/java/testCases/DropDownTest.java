package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.DropDownPage;


public class DropDownTest
{
	WebDriver driver;
	DropDownPage dropDownPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		driver = new ChromeDriver(browserOptions);
		dropDownPage = new DropDownPage(driver); 
		driver.get("http://localhost:7080/dropdown");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void selectOption1Test()
	{
		dropDownPage.selectOptionOne();
		assertEquals(dropDownPage.getSelectedValue(), "Option 1");
	}
	
	@Test
	public void selectOption2Test()
	{
		dropDownPage.selectOptionTwo();
		assertEquals(dropDownPage.getSelectedValue(), "Option 2");
	}
}
