package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FloatingMenuPage;
import TestComponents.BaseTest;

public class FloatingMenuTest extends BaseTest {

	@Test
	public void floatMenu() throws InterruptedException {
		FloatingMenuPage floatingmenupage = landingpage.getfloatMenuPage();
		boolean result = floatingmenupage.floatMenu();

		Assert.assertTrue(result);
	}
}
