package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DownloadNewFilePage;
import page.DragAndDropPage;
import page.DropDownPage;
import page.FloatingMenuPage;
import page.HoverOverPage;
import page.IframePage;
import page.LoginPage;
import page.UploadFilePage;
import util.BrowserFactory;

public class FloatingMenuTest {

	WebDriver driver;

	@Test
	public void flotingMenuCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		FloatingMenuPage floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);
		floatingMenuPage.floatingMenu();

		floatingMenuPage.floatingElement();

		// closing browser
		BrowserFactory.tearDown();

	}

}
