package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.IframePage;

public class IframeTestCases {
	
	private WebDriver browser;
	
	private IframePage contentPage;
	private String messageWriteOnFrame = "I`m writing here";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new IframePage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}

	@Test
	public void contents_display_are_being_changed_with_static() {
		contentPage.goToFrame();
		contentPage.clearFrame();
		contentPage.writeOnFrame(messageWriteOnFrame);
		assertEquals(messageWriteOnFrame, contentPage.getFrameMessage());
	}
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}
