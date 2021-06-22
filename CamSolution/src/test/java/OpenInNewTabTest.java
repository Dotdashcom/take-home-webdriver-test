import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.OpenInNewTab;

public class OpenInNewTabTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/*
	 * Click link and get text from the new tabl that opens
	 */
	@Test
	public void openInNewTab() {
		
		OpenInNewTab newTabPage = new OpenInNewTab(driver);
		newTabPage.clickLinkToLaunchNewTab();
		String result = newTabPage.getTextFromTab();
		assertTrue(result.equals("New Window"));
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
