package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.CheckBoxPage;
import com.takeHomeTest.pages.DropDownPage;
import com.takeHomeTest.pages.TheInternetPage;

public class DropDownTest extends TestBase {

	DropDownPage dropDown;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void dropDownTestOption1() {
		dropDown = theInternetPage.clickDropDownBtn();
		dropDown.option1Selected();
		Assert.assertEquals(dropDown.getSelectedText(), "Option 1", "Option 1 not selected");

	}

	@Test
	public void dropDownTestOption2() {
		dropDown = theInternetPage.clickDropDownBtn();
		dropDown.option2Selected();
		Assert.assertEquals(dropDown.getSelectedText(), "Option 2", "Option 2 not selected");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
