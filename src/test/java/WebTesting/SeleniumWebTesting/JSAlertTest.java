package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class JSAlertTest  extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void JSAlertTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/javascript_alerts");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement jsAlert, jsConfirm, jsPrompt, result;
		String textToSend = "Hello message";
		//saving all the elements that are required
		jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
		jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
		jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		result = driver.findElement(By.id("result"));
		
		//clicking Alert buttion
		jsAlert.click();
		//switching driver focus to alert
		Alert alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		// accepting the alert
		alert.accept();
		
		//clicking confirm button
		jsConfirm.click();
		//switching driver focus to alert
		alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		// accepting the alert
		alert.accept();
		
		jsPrompt.click();
		//switching driver focus to alert
		alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		//sending text into required field
		alert.sendKeys(textToSend);
		//accepting the alert
		alert.accept();
		//checking if the data entered in displayed or not
		Assert.assertEquals(result.getText(), "You entered: " + textToSend);
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}