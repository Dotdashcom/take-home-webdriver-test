package Test_Cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.DropDownPage;
import TestBase.BaseTest;

public class DropDownPageTest extends BaseTest {
	DropDownPage dropDown;

	public DropDownPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		dropDown = new DropDownPage();
	}

	@Test
	public void dropDownTest() {

		// logging into application
		dropDown.getUrl();

		// verifying the first value is selected in the dropDown
		dropDown.selectOption1();

		// verifying the second value is selected in the dropDown
		dropDown.selectOption2();

		// Assert.assertTrue(elementATextAfter.equalsIgnoreCase(elementBTextExpected));

	}

}
