package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DragNDropPage;
import TestComponents.BaseTest;

public class DragNdropTest extends BaseTest {

	@Test
	public void drabNdroptest() throws InterruptedException {
		DragNDropPage dragNdroppage = landingpage.getdragndropPage();

		boolean result = dragNdroppage.dragNdrop();
		Assert.assertTrue(result);

	}

}
