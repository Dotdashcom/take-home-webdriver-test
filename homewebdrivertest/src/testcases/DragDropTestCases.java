package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DragDropPage;

public class DragDropTestCases {
	
	private WebDriver browser;
	
	private DragDropPage dragDropPage;
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		dragDropPage = new DragDropPage(browser);
		browser.manage().window().maximize();
		dragDropPage.goToPage();
	}
	
	@Test
	public void drag_elementA_to_elementB() {
		String beforeColumnA = dragDropPage.getColumnAText();
		String beforeColumnB = dragDropPage.getColumnBText();
		
		dragDropPage.dragAToB();

		String afterColumnA = dragDropPage.getColumnAText();
		String afterColumnB = dragDropPage.getColumnBText();

		assertEquals(beforeColumnA, afterColumnB);
		assertEquals(beforeColumnB, afterColumnA);
	}

	@Test
	public void drag_elementB_to_elementA() {
		String beforeColumnA = dragDropPage.getColumnAText();
		String beforeColumnB = dragDropPage.getColumnBText();
		
		dragDropPage.dragBToA();

		String afterColumnA = dragDropPage.getColumnAText();
		String afterColumnB = dragDropPage.getColumnBText();

		assertEquals(beforeColumnA, afterColumnB);
		assertEquals(beforeColumnB, afterColumnA);
	}

	@AfterEach
	public void exit() {
		browser.quit();
	}
}
