package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DynamicLoadingPage;
import TestComponents.BaseTest;

public class DynamicLoadingTest extends BaseTest {

	@Test
	public void dynamicLoad() throws InterruptedException {

		DynamicLoadingPage dynamicloadingpage = landingpage.getdynamicloadingPage();
		String displayedtextmessage = dynamicloadingpage.displaytext();
		
		Assert.assertEquals(displayedtextmessage, "Hello World!");

	}

}
