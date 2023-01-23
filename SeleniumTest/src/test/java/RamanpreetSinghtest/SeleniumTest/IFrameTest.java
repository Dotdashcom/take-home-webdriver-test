package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.IframePage;
import TestComponents.BaseTest;

public class IFrameTest extends BaseTest {

	@Test
	public void frametest() throws InterruptedException {
		IframePage iframePage = landingpage.getFramePage();	
		Thread.sleep(5000);
		boolean message = iframePage.iframeopen();
		Assert.assertTrue(message);
	}

}
