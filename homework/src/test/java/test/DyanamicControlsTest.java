package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DownloadNewFilePage;
import page.DragAndDropPage;
import page.DropDownPage;
import page.DynamicControlsPage;
import page.FloatingMenuPage;
import page.HoverOverPage;
import page.IframePage;
import page.LoginPage;
import page.NotificationMessagePage;
import page.UploadFilePage;
import util.BrowserFactory;

public class DyanamicControlsTest {

	WebDriver driver;

	@Test
	public void dynamicControlsCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		DynamicControlsPage dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
		dynamicControlsPage.dynamicControlsMenu();

		dynamicControlsPage.clickAndValidate();

		// closing browser
		BrowserFactory.tearDown();

	}

}
