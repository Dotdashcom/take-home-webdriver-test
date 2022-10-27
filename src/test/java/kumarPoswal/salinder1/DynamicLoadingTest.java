package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DynamicLoadingPage;
import com.takeHomeTest.pages.TheInternetPage;

public class DynamicLoadingTest extends TestBase {

	DynamicLoadingPage dynamicLoadingPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void dynamicLoadingTest() {
		dynamicLoadingPage = theInternetPage.clickDynamicLoadingPageBtn();
		dynamicLoadingPage.clickstartBtn();
		Assert.assertEquals(dynamicLoadingPage.getTextHelloWorld(), "Hello World!", "Text does not match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
