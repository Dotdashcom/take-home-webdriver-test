package WebTesting.SeleniumWebTesting;

import java.beans.Visibility;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DynamicControlsTest extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void HomePageTest() throws IOException, InterruptedException
	{
		Boolean notPresent;
		Boolean present;
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_controls");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		
		//clicking remove button
		removeButton.click();
			//wait variable for explicit wait
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			//explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
			try
			{
				// checking if the checkbox is present or not
				notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))).apply(driver);
				//Asserting if element is resent or not
				Assert.assertTrue(notPresent);
			}
			//handling no such element exception as element wont be present
			catch(NoSuchElementException e) {
				notPresent = true;
				//Asserting as element is not present
				Assert.assertTrue(notPresent);
			}
			
			WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
			// clicking Add button
			addButton.click();
			//explicit wait till remove button is visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
			
			// checking if the checkbox is present or not
			present = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))).apply(driver);
			//Asserting if the element is present or not
			Assert.assertFalse(present);

			// Clicking Enable button
			enableButton.click();
			// explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Disable')]")));
			
			WebElement inputText = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/input[1]"));
			//Asserting if the input text place is enabled or not
			Assert.assertTrue(inputText.isEnabled());

			
			
			WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
			//disabled web element is clicked
			disableButton.click();
			//explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
			//check if input text is enabled or not
			Assert.assertFalse(inputText.isEnabled());
			

			
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}
