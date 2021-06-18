import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ContextMenu;

public class ContextMenuTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
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
		boolean alertShown = contextMenuPage.isAlertPresent();
		contextMenuPage.acceptAlert();
		assertTrue(alertShown);		
	}	
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
