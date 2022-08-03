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
import org.openqa.selenium.support.ui.Select;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestDropdown {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dropdown");
		
	}
	
	@Test
	public void dropdownMenuSuccess() {
		// checking option 1 can be successfully chosen
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 1");
		String text1 = dropdown.getFirstSelectedOption().getText();
		assertTrue(text1.equals("Option 1"));
		// checking option 2 can be successfully chosen
		dropdown.selectByVisibleText("Option 2");
		String text2 = dropdown.getFirstSelectedOption().getText();
		assertTrue(text2.equals("Option 2"));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}