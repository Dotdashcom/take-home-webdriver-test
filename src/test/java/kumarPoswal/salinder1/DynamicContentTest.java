package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DynamicContentPage;
import com.takeHomeTest.pages.TheInternetPage;

public class DynamicContentTest extends TestBase {

	DynamicContentPage dynamicContentPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void dynamicContentTest() {
		dynamicContentPage = theInternetPage.clickDynamicContentBtn();
		String textBeforeRefresh = dynamicContentPage.textFromPara();
		dynamicContentPage.refereshPage();
		String textAfterRefresh = dynamicContentPage.textFromPara();
//		System.out.println(textBeforeRefresh);
//		System.out.println(textAfterRefresh);
		Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
