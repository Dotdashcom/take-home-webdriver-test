package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import util.BrowserFactory;

public class DynamicLoadingTest extends BrowserFactory {
	static DynamicLoadingPage dynamicLoadingPage;

	@BeforeMethod
	public static void beforeTests() {
		init("dynamic_loading/2");
		dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);
	}

	@Test(priority = 1)
	public static void testClicksTheStartButtonAndUsesExplicitWaitAndValidatesTextIsDisplayed() {
		dynamicLoadingPage.clickStartButton();
		dynamicLoadingPage.validateTextIsDisplayedAfterStartButtonIsClicked();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
