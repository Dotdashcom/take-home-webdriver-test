package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.DynamicLoadingPage;
import TestBase.BaseTest;

public class DynamicLoadingPageTest extends BaseTest {
	DynamicLoadingPage dynamicLoading;

	public DynamicLoadingPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		dynamicLoading = new DynamicLoadingPage();
	}

	@Test
	public void dynamicLoadingTest() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		dynamicLoading.getUrl();

		// CLicking the start button
		dynamicLoading.clickStart();

		// waiting for the text to load using Explicit wait
		dynamicLoading.explicitWaitOfElement();

		// getting the text from the element before refresh
		String actualText = dynamicLoading.getDynamicElementText();
		String expectedText = "Hello World!";

		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));

	}

}
