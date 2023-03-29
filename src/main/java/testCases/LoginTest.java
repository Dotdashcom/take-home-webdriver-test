package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.LoginPage;
import pageComponents.SecurePage;

public class LoginTest
{
	WebDriver driver;
	LoginPage loginPage;
	SecurePage securePage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		driver = new ChromeDriver(browserOptions);
		loginPage = new LoginPage(driver);
		securePage = new SecurePage(driver);
		driver.get("http://localhost:7080/login");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void validLogin()
	{
		loginPage.setUsername("tomsmith");
		loginPage.setPassword("SuperSecretPassword!");
		loginPage.clickLoginButton();
		assertEquals(securePage.getSecureHeader(), "Secure Area");
		securePage.clickLogoutButton();
	}
	@Test
	public void wrongUsername()
	{
		loginPage.setUsername("a");
		loginPage.clickLoginButton();
		assertEquals(loginPage.getHeader(),"Login Page");
	}	
	@Test
	public void wrongPassword()
	{
		loginPage.setUsername("tomsmith");
		loginPage.setPassword("p");
		loginPage.clickLoginButton();
		assertEquals(loginPage.getHeader(),"Login Page");
	}
}
