package Test_Cases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.CheckBoxesPage;
import TestBase.BaseTest;

public class CheckBoxesPageTest extends BaseTest {
	CheckBoxesPage checkBox;

	public CheckBoxesPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		checkBox = new CheckBoxesPage();
	}

	@Test
	public void selectDeselectCheckBoxes() {
		//Log.info("Trying to logging into the application.");
		// logging into application
		checkBox.getUrl();
		//Select first checkbox
		checkBox.selectCheckbox(checkBox.checkbox1);
		Assert.assertTrue(checkBox.checkbox1.isSelected());
		//Deselect first check box
		checkBox.selectCheckbox(checkBox.checkbox1);
		Assert.assertFalse(checkBox.checkbox1.isSelected());
		//Deselect second check box
		checkBox.selectCheckbox(checkBox.checkbox2);
		Assert.assertFalse(checkBox.checkbox2.isSelected());
		//Select second check box
		checkBox.selectCheckbox(checkBox.checkbox2);
		Assert.assertTrue(checkBox.checkbox2.isSelected());


	}

	@Test
	public void selectAllCheckBoxes() {
		//Log.info("Trying to logging into the application.");
		// logging into application
		checkBox.getUrl();
		List<WebElement> checkBoxes = checkBox.getCheckBoxList();
		for (WebElement cb : checkBoxes) {
			cb.click();
		}
		//Assert.assertTrue(checkBox.checkbox1.isSelected());
		//Assert.assertFalse(checkBox.checkbox1.isSelected());
		// assertTrue(logInPage.verifyLogout());

	}
}
