package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import util.BrowserFactory;

public class DynamicContentTest extends BrowserFactory {
	static DynamicContentPage dynamicContentPage;

	@BeforeMethod
	public static void beforeTests() {
		init("dynamic_content");
		dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);
	}

	@Test(priority = 1)
	public static void testRefreshesThePage3TimesAndValidatesContentChangesAfterEachRefresh() {
		dynamicContentPage.refreshPageOnce();
		dynamicContentPage.validateContentHasChangedAfterFirstRefresh();
		dynamicContentPage.refreshPageTwice();
		dynamicContentPage.validateContentHasChangedAfterSecondRefresh();
		dynamicContentPage.refreshPageAThirdTime();
		dynamicContentPage.validateContentHasChangedAfterThirdRefresh();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
