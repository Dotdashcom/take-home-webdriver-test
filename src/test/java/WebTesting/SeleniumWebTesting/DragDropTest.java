package WebTesting.SeleniumWebTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DragDropTest extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		//initializing the driver
		driver =initializeDriver();
	}
	
	@Test()
	public void DragDropTest() throws IOException, InterruptedException
	{
		Actions action = new Actions(driver);
		//Driver navigating to the URL
		driver.get("http://localhost:7080/drag_and_drop");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//grabbing web Elements and saving to move
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='column-b']"));
		//performing action drag and drop 
		action.moveToElement(source).click().build().perform();
		new Actions(driver)
        .moveToElement(source)
        .pause(Duration.ofSeconds(1))
        .clickAndHold(source)
        .pause(Duration.ofSeconds(1))
        .moveByOffset(2, 0)
        .moveToElement(destination)
        .moveByOffset(2,0)
        .pause(Duration.ofSeconds(1))
        .release().build().perform();
		
		//Asserting if drag and drop is successful or not
		Assert.assertEquals(driver.findElement(By.cssSelector("header")).getText(),"A");
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}