package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ContextMenuPage;
import util.BrowserFactory;

public class ContextMenuTest {

	WebDriver driver;

	@Test
	public void rightClickContextMenu() throws InterruptedException {

		driver = BrowserFactory.init();

		ContextMenuPage contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);
		contextMenuPage.clickMenu();
		contextMenuPage.rightClickElement();

		// closing browser
		BrowserFactory.tearDown();
	}

}
