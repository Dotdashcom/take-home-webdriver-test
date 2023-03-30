package testCases;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.FileDownloadPage;


public class DonloadLinkTest
{
	WebDriver driver;
	FileDownloadPage fileDownloadPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);

		driver = new ChromeDriver(browserOptions);
		fileDownloadPage = new FileDownloadPage(driver);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	@Test
	public void fileDownloadTest()
	{
		driver.get("http://localhost:7080/download");
		fileDownloadPage.clickDownloadLink();
		File f = new File("C:\\Users\\priya\\Downloads\\some-text.txt");
		assertTrue(f.exists());
	}
}
