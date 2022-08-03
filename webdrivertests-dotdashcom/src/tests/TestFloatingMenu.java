/**
 * 
 */
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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


public class TestFloatingMenu {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/floating_menu");
		
	}
	
	@Test
	public void floatingMenuSuccess() {
		WebElement floatingMenu = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		//scroll to end of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// check that the floating menu is still present
		assertTrue(floatingMenu.isDisplayed());
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}