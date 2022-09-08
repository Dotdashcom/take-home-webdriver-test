package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import util.BrowserFactory;

public class DragAndDropTest extends BrowserFactory {
	static DragAndDropPage dragAndDropPage;

	@BeforeMethod
	public static void beforeTests() {
		init("drag_and_drop");
		dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
	}

	@Test(priority = 1)
	public static void testDragsElementAToElementBAndValidatesTextOnElementAAndBAreSwitched() {
		dragAndDropPage.dragAndDropColumnAToColumnB();
		dragAndDropPage.validateTextHasBeenSwitchFromElementBToElementA();
		dragAndDropPage.validateTextHasBeenSwitchFromElementAToElementB();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
