import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.JavaScriptError;

public class JavaScriptErrorTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	/**
	 * Check that JS errors in the console can be detected
	 * Test passes if the expected message was seen in the log entries,
	 * fails otherwise
	 */
	@Test
	public void checkThatErrorsCanBeDetected() {
		JavaScriptError jse = new JavaScriptError(driver);		
		List<String> messages = jse.getLogEntryMessages(); 
		for( int i=0; i < messages.size(); i++) {
			if ( messages.get(i).contains("Cannot read property 'xyz' of undefined") ) { 
				assertTrue(true);
				return;
			}	
		}
		assertTrue("Failed - Did not find expected JS error message", false);
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
