package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import util.BrowserFactory;

public class DropdownTest extends BrowserFactory {
	static DropdownPage dropdownPage;

	@BeforeMethod
	public static void beforeTests() {
		init("dropdown");
		dropdownPage = PageFactory.initElements(driver, DropdownPage.class);
	}

	@Test(priority = 1)
	public static void testSelectsOption1FromDropdownMenuAndValidatesOption1IsSelected() {
		dropdownPage.clickOnDropdown();
		dropdownPage.selectOption1();
		dropdownPage.validateOption1IsSelected();
	}

	@Test(priority = 2)
	public static void testSelectsOption2FromDropdownMenuAndValidatesOption2IsSelected() {
		dropdownPage.clickOnDropdown();
		dropdownPage.selectOption2();
		dropdownPage.validateOption2IsSelected();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
