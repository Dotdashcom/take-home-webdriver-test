import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.WebLink;
import pages.CheckBoxPage;
import pages.DropDownPage;
import pages.DynamicControlPage;

public class DynamicContorl_Test extends BaseTest {
	DynamicControlPage page = null;

	@Test
	public void validateChcckBoxGoneAfterRemoving() {
		page = new DynamicControlPage(driver);
		try {
			driver.get(WebLink.dynamicControlPageUrl);
			Assert.assertTrue(page.verifyCheckBoxIsRemoved());
		}

		catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}

	@Test
	public void validateCheckBoxIsAdded() {
		page = new DynamicControlPage(driver);
		try {
			driver.get(WebLink.dynamicControlPageUrl);
			page.verifyCheckBoxIsRemoved();
			Assert.assertTrue(page.verifyChckBoxIsAdded());
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}
	/*
	@Test
	public void validateTextBoxIsDisabled() {
		page = new DynamicControlPage(driver);
		try {
			driver.get(WebLink.dynamicControlPageUrl);
			page.verifyCheckBoxIsRemoved();
			Assert.assertTrue(page.verifyTextBoxIsDisabled());
			// Assert.assertEquals(page.verifyDropDownOption("Option 1"), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}

	@Test
	public void validateTextBoxEnabled() {
		page = new DynamicControlPage(driver);
		try {
			driver.get(WebLink.dynamicControlPageUrl);
			page.enableTextBox();
			Assert.assertTrue(page.verifyTextBoxIsEnabled());
			// Assert.assertEquals(page.verifyDropDownOption("Option 1"), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}*/

}
