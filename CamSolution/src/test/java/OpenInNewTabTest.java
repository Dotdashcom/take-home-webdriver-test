import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
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
