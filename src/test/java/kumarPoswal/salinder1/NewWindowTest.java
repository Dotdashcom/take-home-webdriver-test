package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.MultipleWindowPage;
import com.takeHomeTest.pages.NewWindowPage;
import com.takeHomeTest.pages.TheInternetPage;

public class NewWindowTest extends TestBase {

	MultipleWindowPage multipleWindowPage;
	TheInternetPage theInternetPage;
	NewWindowPage newWindowPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void newWindowTest() {
		multipleWindowPage = theInternetPage.clicknewWindowPage();
		newWindowPage = multipleWindowPage.clicknewTabBtn();
		Assert.assertEquals(newWindowPage.getHeader(), "New Window", "Text does not match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
