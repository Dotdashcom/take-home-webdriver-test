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
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestNotificationMessage {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/notification_message_rendered");
		
	}
	
	@Test
	public void notificationMessageSuccess() {
		// creating arrrayList of possible messages
		String message1 = "Action successful";
		String message2 = "Action unsuccesful, please try again";
		String message3 = "Action unsuccessful";
		// click on 'click here'
		WebElement clickHere1 = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
		clickHere1.click();
		//assert notificationMessage is one of the provided
		assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
		String notificationMessage1 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		System.out.println(notificationMessage1);
		assertTrue(notificationMessage1.contains(message1) || notificationMessage1.contains(message2) || notificationMessage1.contains(message3));
		
		//repeat
		WebElement clickHere2 = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
		clickHere2.click();
		//assert notificationMessage is one of the provided
		assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
		String notificationMessage2 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		System.out.println(notificationMessage2);
		assertTrue(notificationMessage2.contains(message1) || notificationMessage2.contains(message2) || notificationMessage2.contains(message3));
		
		//repeat again
		WebElement clickHere3 = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
		clickHere3.click();
		//assert notificationMessage is one of the provided
		assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
		String notificationMessage3 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		System.out.println(notificationMessage3);
		assertTrue(notificationMessage3.contains(message1) || notificationMessage3.contains(message2) || notificationMessage3.contains(message3));
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}