package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DropDownPage;
import TestComponents.BaseTest;

public class DropDownTest extends BaseTest {

	@Test
	public void dropDown() throws InterruptedException {
		DropDownPage dropdownpage = landingpage.getdropdownPage();
		String firstoption = dropdownpage.firstdropDown();
		Assert.assertEquals(firstoption, "Option 1");
		String secondoption = dropdownpage.seconddropDown();
		Assert.assertEquals(secondoption, "Option 2");
	}
}
