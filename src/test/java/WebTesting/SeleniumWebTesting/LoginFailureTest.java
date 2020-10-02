package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import PageObjects.LoginPage;
import resources.base;

public class LoginFailureTest extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get("http://localhost:7080/login");
		String expectedHomePageURL = "The Internet";;
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
	}
	
	@Test()
	public void LoginFailureTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		LoginPage lp = new LoginPage(driver);		
		lp.getEmail().sendKeys("tomsmith123");
		lp.getpassword().sendKeys("SuperSecretPassword!123");
		lp.getLogin().click();
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualTextLoggedIn = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertEquals(actualTextLoggedIn, "Your username is invalid!\n" + "×");
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}
