package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.FloatingMenuPage;
import com.takeHomeTest.pages.TheInternetPage;

public class FloatingMenuTest extends TestBase {

	FloatingMenuPage floatingMenuPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void floatingMenuTest() {
		floatingMenuPage = theInternetPage.clickfloatingMenuBtn();
		floatingMenuPage.scrollToBottom();
//		Utils.sleep(2000);
		Assert.assertEquals(floatingMenuPage.isMenuDisplayed(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
