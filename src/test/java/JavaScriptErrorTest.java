import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.JavaScriptError;

public class JavaScriptErrorTest {

	private WebDriver driver = null;
	
	@Before
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
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
