package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DynamicControlsPage;
import TestComponents.BaseTest;

public class DynamicControlTest extends BaseTest {

	@Test
	public void dynamicControl() throws InterruptedException {
		DynamicControlsPage dynamiccontrolpage = landingpage.getdynamicControlPage();
		boolean hasDisappeared = dynamiccontrolpage.checkboxdissapear();
		Assert.assertTrue(hasDisappeared);
		boolean hasAppeared = dynamiccontrolpage.checkboxappear();
		Assert.assertTrue(hasAppeared);
		boolean isTextBoxEnable = dynamiccontrolpage.textBoxenable();
		Assert.assertTrue(isTextBoxEnable);

	}

}
