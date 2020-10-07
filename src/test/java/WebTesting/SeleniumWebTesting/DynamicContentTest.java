package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DynamicContentTest  extends base {

	@Test()
	public void DynamicContentTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_content");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//saving web element for refresing the page
		WebElement clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		
		String oldContent = driver.findElement(By.cssSelector("body")).getText();
		//refreshing through driver refresh button
		driver.navigate().refresh();
		driver.navigate().refresh();
		
		String newContent = driver.findElement(By.cssSelector("body")).getText();
		//asserting if the old content is different then new content
		Assert.assertNotEquals(oldContent, newContent);
		
		String old1Content = driver.findElement(By.cssSelector("body:nth-child(2) > div.row:nth-child(2)")).getText();
		//Refreshing through webelement Grabbing element again to remove Stale Element reference exception
		clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		clickHereRefresh.click();
		clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		clickHereRefresh.click();
		String new1Content = driver.findElement(By.cssSelector("body:nth-child(2) > div.row:nth-child(2)")).getText();
		//asserting if the old content is different then new content
		Assert.assertNotEquals(old1Content, new1Content);
	}

}

