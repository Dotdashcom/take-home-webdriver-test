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

import java.util.ArrayList;


public class TestOpenInNewTab {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/windows");
		
	}
	
	@Test
	public void newTabSuccess() {
		// click on 'click here'
		WebElement clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		clickHere.click();
		// switch to new tab, and check that title is "New Window"
		try {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
			assertTrue(driver.getTitle().equals("New Window"));
		} catch (Exception e) {
			assertTrue(false); //test fails
		}
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}