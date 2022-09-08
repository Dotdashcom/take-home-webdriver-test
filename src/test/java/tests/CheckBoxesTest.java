package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import util.BrowserFactory;

public class CheckBoxesTest extends BrowserFactory {
	static CheckBoxesPage checkBoxesPage;

	@BeforeMethod
	public static void beforeTests() {
		init("checkboxes");
		checkBoxesPage = PageFactory.initElements(driver, CheckBoxesPage.class);
	}

	@Test(priority = 1)
	public static void testChecksCheckBox1() {
		checkBoxesPage.checkCheckBox1();
		checkBoxesPage.validateCheckBox1IsChecked();
	}

	@Test(priority = 2)
	public static void testUnchecksCheckBox1() {
		checkBoxesPage.checkCheckBox1();
		checkBoxesPage.uncheckCheckBox1();
		checkBoxesPage.validateCheckBox1IsUnchecked();
	}

	@Test(priority = 3)
	public static void testUnchecksCheckBox2() {
		checkBoxesPage.uncheckCheckBox2();
		checkBoxesPage.validateCheckBox2IsUnChecked();
	}

	@Test(priority = 4)
	public static void testChecksCheckBox2() {
		checkBoxesPage.uncheckCheckBox2();
		checkBoxesPage.checkCheckBox2();
		checkBoxesPage.validateCheckBox2IsChecked();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
