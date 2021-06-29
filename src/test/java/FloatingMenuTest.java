import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.FloatingMenu;

public class FloatingMenuTest {

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
	 * Scroll page and ensure floating menu is still visible
	 */
	@Test
	public void checkMenuShowsWhenPageIsScrolled() {		
		FloatingMenu menuPage = new FloatingMenu(driver);
		menuPage.scrollToBottom();
		boolean menuShows = menuPage.isMenuVisible();
		assertTrue("Floating menu did not show", menuShows);
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
