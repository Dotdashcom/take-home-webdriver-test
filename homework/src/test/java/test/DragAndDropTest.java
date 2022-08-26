package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DragAndDropPage;
import util.BrowserFactory;

public class DragAndDropTest {

	WebDriver driver;

	@Test
	public void dragAndDrop() throws InterruptedException {

		driver = BrowserFactory.init();

		DragAndDropPage dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
		dragAndDropPage.dragAndDropMenu();
		dragAndDropPage.dragAndDropToAndFrom();

		// closing browser
		BrowserFactory.tearDown();

	}

}
