import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.NotificationMessage;

public class NotificationMessageTest {

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
	 * Click link and get the flash message
	 */
	@Test
	public void clickManyTimesToGenerateMessages() {
		
		// Number of times to generate messages
		final int ATTEMPTS = 10;
		
		NotificationMessage messagePage = new NotificationMessage(driver);
		Set<String> allowedMessages = new HashSet<String>();
		allowedMessages.add("Action successful\n×");
		allowedMessages.add("Action Unsuccessful\n×");
		allowedMessages.add("Action unsuccesful, please try again\n×");
		
		
		for (int i=0; i < ATTEMPTS ; i++) {
			messagePage.loadNewMessage();
			String message = messagePage.getMessage();
			assertTrue("Disallowed message detected", allowedMessages.contains(message));
		}
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}

