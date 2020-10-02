package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class MouseHoverTest  extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void MouseHoverTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/hovers");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		//action object is created
		Actions action = new Actions(driver);
		WebElement hoverElement1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]"));
		WebElement ExpectedHoverElement1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
		//performing hover on element
		action.moveToElement(hoverElement1).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement1.isDisplayed());
		
		WebElement hoverElement2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]"));
		WebElement ExpectedHoverElement2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
		//performing hover on element
		action.moveToElement(hoverElement2).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement2.isDisplayed());
		
		WebElement hoverElement3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]"));
		WebElement ExpectedHoverElement3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
		//performing hover on element
		action.moveToElement(hoverElement3).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement3.isDisplayed());
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}