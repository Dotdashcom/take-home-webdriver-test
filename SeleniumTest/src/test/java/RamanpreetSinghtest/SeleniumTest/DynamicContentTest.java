package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DynamicContentPage;
import TestComponents.BaseTest;

public class DynamicContentTest extends BaseTest {

	@Test
	public void dynamiccontenttest() throws InterruptedException {
		DynamicContentPage dynamiccontentpage = landingpage.getdynamiccontentPage();
		boolean result =dynamiccontentpage.refreshPage();
		
		Assert.assertFalse(result);

	}

}
