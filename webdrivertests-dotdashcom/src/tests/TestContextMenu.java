/**
 * 
 */
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

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


public class TestContextMenu {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/context_menu");
		
	}
	
	@Test
	public void contextMenuSuccess() {
		Actions actions = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.xpath("//*[@id='hot-spot']"));
		// right click on context menu
		actions.contextClick(contextMenu).perform();
		
		try {
			driver.switchTo().alert();
			// alert pop-up occurs
			assertTrue(true);
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