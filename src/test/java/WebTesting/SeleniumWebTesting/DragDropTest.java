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
		WebElement destination = driver.findElement(By.id("column-b"));
		//performing action drag and drop 
		action.dragAndDrop(source, destination).perform();
		
		//Asserting if drag and drop is successful or not
		Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/header[1]")).getText(),"B");
		Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/header[1]")).getText(),"A");

	}

}