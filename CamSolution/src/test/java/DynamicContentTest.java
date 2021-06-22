import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DynamicContent;

public class DynamicContentTest {

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
	 * Do a couple of refreshes and confirm that the dynamic content is changing
	 */
	@Test
	public void dynamicContentDiffersOnRefreshes() {
		
		DynamicContent dynamicContentPage = new DynamicContent(driver);
		
		// Get content from first load
		String first = dynamicContentPage.getDynamicContent();
		
		// Refresh and get content
		driver.navigate().refresh();
		String second = dynamicContentPage.getDynamicContent();
		
		// Refresh and get content
		driver.navigate().refresh();
		String third = dynamicContentPage.getDynamicContent();
		
		// Check that no two of the page loads were the same
		assertFalse(first.equals(second));
		assertFalse(first.equals(third));
		assertFalse(second.equals(third));		
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
