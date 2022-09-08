package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OpenInNewTabPage;
import util.BrowserFactory;

public class OpenInNewTabTest extends BrowserFactory {
	static OpenInNewTabPage openInNewTabPage;

	@BeforeMethod
	public static void beforeTests() {
		init("windows");
		openInNewTabPage = PageFactory.initElements(driver, OpenInNewTabPage.class);
	}

	@Test(priority = 1)
	public static void testClicksOnTheClickHereLinkAndTestAssertsThatANewTabIsOpenedWithTextNewWindow() {
		openInNewTabPage.clickClickHereHyperlink();
		openInNewTabPage.switchtingToTheNewTab();
		openInNewTabPage.validateNewTabIsOpenWithNewWindowTextPresent();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
