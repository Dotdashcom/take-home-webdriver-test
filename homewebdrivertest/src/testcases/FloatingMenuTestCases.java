package testcases;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FloatingMenuPage;

public class FloatingMenuTestCases {
	
	private WebDriver browser;
	
	private FloatingMenuPage contentPage;
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new FloatingMenuPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}

	@Test
	public void contents_display_are_being_changed_with_static() {
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript("window.scrollBy(0,250)", "");
		contentPage.clickHomeMenu();
		assertTrue(browser.getCurrentUrl().contains("#home"));
		contentPage.clickNewsMenu();
		assertTrue(browser.getCurrentUrl().contains("#news"));
		contentPage.clickContactMenu();
		assertTrue(browser.getCurrentUrl().contains("#contact"));
		contentPage.clickAboutMenu();
		assertTrue(browser.getCurrentUrl().contains("#about"));
	}
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}
