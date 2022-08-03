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
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestDynamicContent {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_content");
		
	}
	
	@Test
	public void dynamicContentSuccess() {
		String original = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).getText();
		// refresh and check that text in first box has changed
		driver.navigate().refresh();
		String second = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).getText();
		assertTrue(!original.equals(second));
		// refresh and check that text in first box has changed, again
		driver.navigate().refresh();
		String third = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).getText();
		assertTrue(!second.equals(third));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}