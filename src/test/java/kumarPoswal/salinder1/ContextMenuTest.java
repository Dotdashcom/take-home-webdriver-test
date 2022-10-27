package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.ContextMenuPage;
import com.takeHomeTest.pages.TheInternetPage;

public class ContextMenuTest extends TestBase {

	ContextMenuPage contextMenu;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void contextMenuTest() {
		theInternetPage = new TheInternetPage(webDriver, true);
		contextMenu = theInternetPage.clickcontextMenuBtn();
		contextMenu.rightClick();
		Assert.assertEquals(contextMenu.textFromAlert(), "You selected a context menu", "Alert text does not match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
