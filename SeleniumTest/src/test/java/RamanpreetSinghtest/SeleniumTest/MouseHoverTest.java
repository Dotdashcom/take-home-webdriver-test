package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.MouseOverPage;
import TestComponents.BaseTest;

public class MouseHoverTest extends BaseTest {

	@Test
	public void mouseHovertest() throws InterruptedException {

		MouseOverPage mouseoverpage = landingpage.getMouseHoverPage();
		boolean result = mouseoverpage.mousehover();
		Assert.assertTrue(result);
	}

}
