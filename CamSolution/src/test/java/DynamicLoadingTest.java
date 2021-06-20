import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DynamicLoading;

public class DynamicLoadingTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
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
		assertTrue(message.equals("Hello World!"));
			
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
