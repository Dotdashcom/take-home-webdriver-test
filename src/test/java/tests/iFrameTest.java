package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.iFramePage;
import util.BrowserFactory;

public class iFrameTest extends BrowserFactory {
	static iFramePage iframePage;

	@BeforeMethod
	public static void beforeTests() {
		init("iframe");
		iframePage = PageFactory.initElements(driver, iFramePage.class);
	}

	@Test(priority = 1)
	public static void testSwitchesToiframeToTypeTextAndValidatesTheTypedTextIsAsExpected() {
		iframePage.handlingJavaScriptAlert(); //To see the text being typed
		iframePage.switctToiFrame();
		iframePage.sendingTextToiFrame();
		iframePage.validateTextIsPresentInInputBoxOfiFrame();		
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
