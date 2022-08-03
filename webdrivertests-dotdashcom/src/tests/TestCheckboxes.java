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
import static org.junit.Assert.assertFalse;

public class TestCheckboxes {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/checkboxes");
		
	}
	
	@Test
	public void checkboxSuccess() {
		// check checkbox1 and ensure it is checked
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		checkbox1.click();
		assertTrue(checkbox1.isSelected());
		// un-check checkbox2 and ensure it is not checked
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		checkbox2.click();
		assertFalse(checkbox2.isSelected());		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}