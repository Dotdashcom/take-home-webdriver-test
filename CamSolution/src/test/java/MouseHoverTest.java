import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MouseHover;

public class MouseHoverTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/*
	 * Hover over each image and get the caption text
	 */
	@Test
	public void hoverAndGetCaptionText() {
		
		MouseHover mouseHoverPage = new MouseHover(driver);
				
		mouseHoverPage.hoverOverImage(0);		
		String user1Caption = mouseHoverPage.getVisibleCaptionFor(0);
		System.out.println("Can see caption: " + user1Caption);
		
		mouseHoverPage.hoverOverImage(1);		
		String user2Caption = mouseHoverPage.getVisibleCaptionFor(1);
		System.out.println("Can see caption: " + user2Caption);
		
		mouseHoverPage.hoverOverImage(2);		
		String user3Caption = mouseHoverPage.getVisibleCaptionFor(2);
		System.out.println("Can see caption: " + user3Caption);
	 
		assertTrue(user1Caption.contains("name: user1") && user1Caption.contains("View profile"));
		assertTrue(user2Caption.contains("name: user2") && user2Caption.contains("View profile"));
		assertTrue(user3Caption.contains("name: user3") && user3Caption.contains("View profile"));
			
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
