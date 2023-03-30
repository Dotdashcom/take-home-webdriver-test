package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.IframePage;


public class iframeTest
{
	WebDriver driver;
	IframePage iFramePage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		iFramePage = new IframePage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void iFrameInputTest()
	{
		driver.get("http://localhost:7080/iframe");
		iFramePage.clickOnMceEditor();
		iFramePage.inputText("testing");
		assertEquals(iFramePage.getValueFromEditor(), "testing");
	}
}
