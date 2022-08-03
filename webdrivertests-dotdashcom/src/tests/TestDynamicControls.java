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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.Duration;
import java.util.List;


public class TestDynamicControls {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_controls");
		
	}
	
	@Test
	public void dynamicControlsSuccess() {
		// click on remove button and do explicit wait, then check for lack of checkbox
		WebElement removeAddButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
		removeAddButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		List<WebElement> checkbox1 = driver.findElements(By.id("checkbox"));
		assertTrue(checkbox1.isEmpty());
		
		// click on add button and do explicit wait, then check for checkbox
		removeAddButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
		assertTrue(true); // if the wait.until() does not fail, checkbox is present
		
		// click on enable button and do explicit wait, then check for text box enabled
		WebElement enableDisableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
		enableDisableButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));
		assertTrue(true); // if the wait.until() does not fail, textbox is enabled
		
		// click on disable button and do explicit wait, then check for text box disabled
		enableDisableButton.click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='input-example']/button"), "Enable"));
		WebElement textbox = driver.findElement(By.xpath("//*[@id='input-example']/input"));
		assertFalse(textbox.isEnabled());
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}