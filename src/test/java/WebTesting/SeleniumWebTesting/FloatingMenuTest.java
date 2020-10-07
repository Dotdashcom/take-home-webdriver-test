package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class FloatingMenuTest  extends base {
	
	@Test()
	public void FloatingMenuTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/floating_menu");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement menu = driver.findElement(By.cssSelector("#menu"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Assert.assertTrue(menu.isDisplayed());
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
        
        //checking if the menu is still displayed or not after scrolling
        Assert.assertTrue(menu.isDisplayed());
	}

}
