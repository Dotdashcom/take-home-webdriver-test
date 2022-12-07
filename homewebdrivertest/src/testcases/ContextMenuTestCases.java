package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ContextMenuPage;

public class ContextMenuTestCases {

	private WebDriver browser;
	
	private ContextMenuPage contextMenuPage;
	
	private String alertFeedback = "You selected a context menu";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contextMenuPage = new ContextMenuPage(browser);
		browser.manage().window().maximize();
		contextMenuPage.goToPage();
	}
	
	@Test
	public void right_click_at_hot_spot() {
		contextMenuPage.rightClickAtHotSpot();
		assertEquals(alertFeedback, browser.switchTo().alert().getText());
		browser.switchTo().alert().accept();		
	}
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}
