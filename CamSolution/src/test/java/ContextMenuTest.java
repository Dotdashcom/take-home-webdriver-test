import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import pages.ContextMenu;

public class ContextMenuTest {

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
	 * Check that alert is not present when page loads
	 */
	@Test
	public void alertIsNotPresentWhenPageLoads() {
		ContextMenu contextMenuPage = new ContextMenu(driver);
		assertFalse(contextMenuPage.isAlertPresent());
	}
	
	/**
	 * Check that alert loads when right click
	 */
	@Test
	public void alertLoadsOnContextMenuClick() {
		ContextMenu contextMenuPage = new ContextMenu(driver);
		contextMenuPage.rightClickHotspot();
		String alertMessage = contextMenuPage.getAlertText();
		contextMenuPage.acceptAlert();
		assertTrue(alertMessage.contains("You selected a context menu"));		
	}	
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
