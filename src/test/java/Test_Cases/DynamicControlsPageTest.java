package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.DynamicControlPage;
import TestBase.BaseTest;

public class DynamicControlsPageTest extends BaseTest {
	DynamicControlPage dynamicControl;

	public DynamicControlsPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		dynamicControl = new DynamicControlPage();
	}

	@Test
	public void removingAddingCheckBox() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		dynamicControl.getUrl();

		// CLicking the remove button
		dynamicControl.clickRemoveButton();

		// waiting for the text to load using Explicit wait
		dynamicControl.explicitWaitOfElementMessageCheckbox();

		// getting the text from the element
		String actualRemovedText = dynamicControl.getCheckBoxMessage();
		String expectedRemovedText = "It's gone!";

		Assert.assertTrue(actualRemovedText.equalsIgnoreCase(expectedRemovedText));

		// CLicking the add button
		dynamicControl.clickAddButton();

		// waiting for the text to load using Explicit wait
		dynamicControl.explicitWaitOfElementMessageCheckbox();

		// getting the text from the element
		String actualAddedText = dynamicControl.getCheckBoxMessage();
		String expectedAddedText = "It's back!";

		Assert.assertTrue(actualAddedText.equalsIgnoreCase(expectedAddedText));
	}

	@Test
	public void enableDisableTextBox() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		dynamicControl.getUrl();

		// CLicking the enable button
		dynamicControl.clickEnableTextBox();

		// waiting for the text to load using Explicit wait
		dynamicControl.explicitWaitOfElementMessageCheckbox();

		// getting the text from the element
		String actualEnableText = dynamicControl.getCheckBoxMessage();
		String expectedEnableText = "It's enabled!";

		Assert.assertTrue(actualEnableText.equalsIgnoreCase(expectedEnableText));

		// CLicking the disable button
		dynamicControl.clickDisableTextBox();

		// waiting for the text to load using Explicit wait
		dynamicControl.explicitWaitOfElementMessageCheckbox();

		// getting the text from the element
		String actualDisableText = dynamicControl.getCheckBoxMessage();
		String expectedDisableText = "It's disabled!";

		Assert.assertTrue(actualDisableText.equalsIgnoreCase(expectedDisableText));
	}
}
