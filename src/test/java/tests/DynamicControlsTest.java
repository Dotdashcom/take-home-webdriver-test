package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import util.BrowserFactory;

public class DynamicControlsTest extends BrowserFactory {
	static DynamicControlsPage dynamicControlsPage;

	@BeforeMethod
	public static void beforeTests() {
		init("dynamic_controls");
		dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
	}

	@Test(priority = 1)
	public static void testClicksOnTheRemoveButtonAndUtilizesExplicitWaitAndValidatesTheCheckboxIsGone() {
		dynamicControlsPage.clickRemoveButton();
		dynamicControlsPage.validateRemoveButtonFunctionality();
		dynamicControlsPage.validateRemoveButtonRemovedCheckbox();
	}

	@Test(priority = 2)
	public static void testClicksOnTheAddButtonAndUtilizesExplicitWaitAndValidatesTheCheckboxIsPresent() {
		dynamicControlsPage.clickRemoveButton();
		dynamicControlsPage.clickAddButton();
		dynamicControlsPage.validateAddButtonFunctionality();
		dynamicControlsPage.validateAddButtonAddedCheckbox();
	}

	@Test(priority = 3)
	public static void testClicksOnTheEnableButtonAndUtilizesExplicitWaitAndValidatesTextBoxIsEnabled() {
		dynamicControlsPage.clickEnableButton();
		dynamicControlsPage.validateEnableButtonFunctionality();
		dynamicControlsPage.validateInputBoxIsEnabled();
	}

	@Test(priority = 4)
	public static void testClicksOnTheDisableButtonAndUtilizesExplicitWaitAndValidatesTextBoxIsDisabled() {
		dynamicControlsPage.clickEnableButton();
		dynamicControlsPage.clickDisableButton();
		dynamicControlsPage.validateDisableButtonFunctionality();
		dynamicControlsPage.validateInputBoxIsDisabled();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
