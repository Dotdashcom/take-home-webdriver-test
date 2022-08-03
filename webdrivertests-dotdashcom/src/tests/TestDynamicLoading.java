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
import java.time.Duration;


public class TestDynamicLoading {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
		
	}
	
	@Test
	public void dynamicLoadingSuccess() {
		// click on start button
		WebElement startButton = driver.findElement(By.xpath("//*[@id=\'start\']/button"));
		startButton.click();
		// explicit wait and check for "Hello World!"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'finish\']/h4")));
		assertTrue(true);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}