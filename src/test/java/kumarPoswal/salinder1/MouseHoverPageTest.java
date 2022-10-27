package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.MouseHoverPage;
import com.takeHomeTest.pages.TheInternetPage;

public class MouseHoverPageTest extends TestBase {

	MouseHoverPage mouseHoverPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void hoverTestImageOne() {
		mouseHoverPage = theInternetPage.clickhoverPageBtn();
		mouseHoverPage.hoverOverImageOne();
		Assert.assertEquals(mouseHoverPage.IsfirstHeaderDisplayed(), true);
	}

	@Test
	public void hoverTestImageTwo() {
		mouseHoverPage = theInternetPage.clickhoverPageBtn();
		mouseHoverPage.hoverOverImageTwo();
		Assert.assertEquals(mouseHoverPage.IsSecondHeaderDisplayed(), true);
	}

	@Test
	public void hoverTestImageThird() {
		mouseHoverPage = theInternetPage.clickhoverPageBtn();
		mouseHoverPage.hoverOverImageThird();
		Assert.assertEquals(mouseHoverPage.IsThirdHeaderDisplayed(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
