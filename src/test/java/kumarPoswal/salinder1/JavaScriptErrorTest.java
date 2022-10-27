package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.JavaScriptErrorPage;
import com.takeHomeTest.pages.TheInternetPage;

public class JavaScriptErrorTest extends TestBase {

	JavaScriptErrorPage javaScriptErrorPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void javaScriptErrorTest() {
		javaScriptErrorPage = theInternetPage.clickjavaScriptErrorPage();
		Assert.assertEquals(javaScriptErrorPage.verifyError("Cannot read properties of undefined (reading 'xyz')"),
				true);

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
