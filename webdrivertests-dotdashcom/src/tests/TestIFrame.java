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


public class TestIFrame {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/iframe");
		
	}
	
	@Test
	public void iFrameSuccess() {
		// switch into iframe and type
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//*[@id='tinymce']/p")).sendKeys("test text");
		// assert that text appears in iframe
		WebElement text = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
		assertTrue(text.getText().equals("Your content goes here.test text"));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}