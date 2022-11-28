package Test_Cases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.DynamicContentPage;
import TestBase.BaseTest;

public class DynamicContentPageTest extends BaseTest {
	DynamicContentPage dynamicContent;

	public DynamicContentPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		dynamicContent = new DynamicContentPage();
	}

	@Test
	public void dynamicContentTest() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		dynamicContent.getUrl();

		// getting the text from the element before refresh
		String dynamicContentTextBefore = dynamicContent.getText();
		System.out.println(dynamicContentTextBefore);
		// verifying the second value is selected in the dropDown
		dynamicContent.refeshPage();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// getting the text from the element after refresh
		String dynamicContentTextAfter = dynamicContent.getText();
		System.out.println(dynamicContentTextAfter);
		Assert.assertFalse(dynamicContentTextBefore.equalsIgnoreCase(dynamicContentTextAfter));

	}

}
