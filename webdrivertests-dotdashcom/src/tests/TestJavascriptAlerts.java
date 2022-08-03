/**
 * 
 */
package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

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


public class TestJavascriptAlerts {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/javascript_alerts");
		
	}
	
	@Test
	public void jsAlertSuccess() {
		// gets element for js alert button and clicks, then confirms alert message
		WebElement JSAlertButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
		JSAlertButton.click();
		try {
			driver.switchTo().alert().accept();
			// alert pop-up occurs
			assertTrue(true);
		} catch (NoAlertPresentException E) {
			// no alert pop-up occurs
			assertTrue(false);
		}
		
		// gets element for js confirm button and clicks, then confirms alert message
		WebElement JSConfirmButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
		JSConfirmButton.click();
		try {
			driver.switchTo().alert().accept();
			// alert pop-up occurs
			assertTrue(true);
		} catch (NoAlertPresentException E) {
			// no alert pop-up occurs
			assertTrue(false);
		}
		
		// gets element for js prompt button, clicks, types a message, then confirms
		WebElement JSPromptButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
		JSPromptButton.click();
		try {
			// type text and send then make sure alert sent message
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("test text");
			alert.accept();
			WebElement response = driver.findElement(By.xpath("//*[@id='result']"));
			// alert pop-up occurs
			assertTrue(response.getText().equals("You entered: test text"));
		} catch (NoAlertPresentException E) {
			// no alert pop-up occurs
			assertTrue(false);
		}
		
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}