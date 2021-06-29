import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.DynamicLoading;

public class DynamicLoadingTest {

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
	
	/*
	 * Click the Start button and wait for the message
	 */
	@Test
	public void clickStartAndWaitForMessage() {
		
		DynamicLoading dynamicLoadingPage = new DynamicLoading(driver);
		
		dynamicLoadingPage.clickStartButton();
		String message = dynamicLoadingPage.getCompletionMessage();
		System.out.println("Got message: " + message);
		
		// Check that message was as expected 
		assertTrue("Did not get expected message", message.equals("Hello World!"));
			
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
