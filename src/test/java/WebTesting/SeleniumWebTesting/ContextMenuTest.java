package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class ContextMenuTest extends base {

	@Test()
	public void ContextMenuTest() throws IOException, InterruptedException
	{
		Actions action = new Actions(driver);
		//Driver navigating to the URL
		driver.get("http://localhost:7080/context_menu");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//saving menu in a variable to perform action
		WebElement contextMenu = driver.findElement(By.cssSelector("#hot-spot"));
		//performing context click with help of action
		action.contextClick(contextMenu).perform();
		//changing driver focus to alert
		Alert alert = driver.switchTo().alert(); 
		String expectedAlertMessage = "You selected a context menu";
		//Asserting if the text in alert is as expected
		Assert.assertEquals(alert.getText(),expectedAlertMessage);
		//clicking ok to change driver focus to window
		alert.accept();
	}

}
