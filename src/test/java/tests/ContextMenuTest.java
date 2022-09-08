package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import util.BrowserFactory;

public class ContextMenuTest extends BrowserFactory {
	static ContextMenuPage contextMenuPage;

	@BeforeMethod
	public static void beforeTests() {
		init("context_menu");
		contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);
	}

	@Test(priority = 1)
	public static void testRightClicksOnTheContextMenuAndValidatesTheAlertMenuText() {
		contextMenuPage.rightClickInsideBox();
		contextMenuPage.validateJavaScriptAlertMenuText();
		contextMenuPage.pressingOKOnJavaScriptAlert();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
