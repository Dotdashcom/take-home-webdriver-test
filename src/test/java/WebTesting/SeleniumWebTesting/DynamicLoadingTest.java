package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DynamicLoadingTest  extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void DynamicLoadingTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_loading/2");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//wait variable created
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		
		WebElement startButton = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div:nth-child(4) > button:nth-child(1)"));
		startButton.click();
		//Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText();
		//asserting if the output is same as expected
		Assert.assertEquals(actual, "Hello World!");
		
	}
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();
		//driver.quit();
	}
}
