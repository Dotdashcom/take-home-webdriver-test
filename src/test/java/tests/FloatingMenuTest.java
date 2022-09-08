package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import util.BrowserFactory;

public class FloatingMenuTest extends BrowserFactory {
	static FloatingMenuPage floatingMenuPage;

	@BeforeMethod
	public static void beforeTests() {
		init("floating_menu");
		floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);
	}

	@Test(priority = 1)
	public static void testScrollsThePageAndValidatesFloatingMenuIsStillDisplayed() {
		floatingMenuPage.scrollPageDown();
		floatingMenuPage.validateFloatingMenuIsPresentAfterScrollingDown();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
