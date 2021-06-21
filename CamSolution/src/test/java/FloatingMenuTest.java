import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FloatingMenu;
import pages.MouseHover;

public class FloatingMenuTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
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
		assertTrue(menuShows);
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
