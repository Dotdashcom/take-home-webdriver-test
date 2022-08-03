/**
 * 
 */
package tests;

import org.openqa.selenium.By;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestMouseHover {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/hovers");
		
	}
	
	@Test
	public void mouseHoverSuccess() {
		// get elements for each image
		WebElement user1image = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
		WebElement user2image = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
		WebElement user3image = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
		Actions action = new Actions(driver);
		// hover over user1 and check for description
		action.moveToElement(user1image).perform();
		assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).isDisplayed());
		// hover over user2 and check for description
		action.moveToElement(user2image).perform();
		assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5")).isDisplayed());
		// hover over user3 and check for description
		action.moveToElement(user3image).perform();
		assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5")).isDisplayed());
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}