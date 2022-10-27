package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.FramePage;
import com.takeHomeTest.pages.IframePage;
import com.takeHomeTest.pages.TheInternetPage;

public class FramePageTest extends TestBase {

	FramePage framePage;
	TheInternetPage theInternetPage;
	IframePage iframePage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void frameTest() {
		framePage = theInternetPage.clickframePageBtn();
		iframePage = framePage.clickiFrameBtn();
		Assert.assertEquals(iframePage.getTextFromIframe(), "Your content goes here.", "Text does not match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
