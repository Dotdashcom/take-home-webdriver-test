package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.CheckBoxPage;
import com.takeHomeTest.pages.TheInternetPage;

public class CheckBoxPageTest extends TestBase {

	CheckBoxPage checkBoxPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	// selecting all check boxes
	@Test
	public void checkAllBoxesTest() {
		checkBoxPage = theInternetPage.clickcheckBoxesBtn();
		if (!checkBoxPage.isCheckBox1Selected()) {
			checkBoxPage.clickcheckBox1();
		}

		if (!checkBoxPage.isCheckBox2Selected()) {
			checkBoxPage.clickcheckBox2();
		}

		Assert.assertEquals(checkBoxPage.isCheckBoxesSelected(), true);

	}

	// unselecting all check boxes
	@Test
	public void UncheckAllBoxesTest() {
		checkBoxPage = theInternetPage.clickcheckBoxesBtn();
		if (checkBoxPage.isCheckBox1Selected()) {
			checkBoxPage.clickcheckBox1();
		}

		if (checkBoxPage.isCheckBox2Selected()) {
			checkBoxPage.clickcheckBox2();
		}

		Assert.assertEquals(checkBoxPage.isCheckBoxesSelected(), false);

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
