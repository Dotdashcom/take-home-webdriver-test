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
import page.JavaScriptErrorPage;
import page.LoginPage;
import page.NewTabLinkPage;
import page.UploadFilePage;
import util.BrowserFactory;

public class NewTabLinkTest {

	WebDriver driver;

	@Test
	public void newTabLinkCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		NewTabLinkPage newtabLinkPage = PageFactory.initElements(driver, NewTabLinkPage.class);
		newtabLinkPage.newTabLinkMenu();
		newtabLinkPage.assertNewWindowTab();

		// closing browser
		BrowserFactory.tearDown();

	}

}
