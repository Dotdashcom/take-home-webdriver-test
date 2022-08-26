package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DownloadNewFilePage;
import page.DragAndDropPage;
import page.DropDownPage;
import page.DynamicLoadingPage;
import page.FloatingMenuPage;
import page.HoverOverPage;
import page.IframePage;
import page.LoginPage;
import page.NotificationMessagePage;
import page.UploadFilePage;
import util.BrowserFactory;

public class DyanamicLoadingTest {

	WebDriver driver;

	@Test
	public void dynamicLoadingCheck() {

		driver = BrowserFactory.init();
		DynamicLoadingPage dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);
		dynamicLoadingPage.dynamicLoadingMenu();

		dynamicLoadingPage.clickExample2();
		// closing browser
		BrowserFactory.tearDown();

	}

}
