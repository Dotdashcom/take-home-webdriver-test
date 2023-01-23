package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ContextMenuPage;
import TestComponents.BaseTest;

public class ContextMenuTest extends BaseTest {

	@Test
	public void contextMenu() throws InterruptedException {
		ContextMenuPage contextpage = landingpage.getContextPage();
		String message = contextpage.rightClick();
		Assert.assertEquals(message, "You selected a context menu");
	}

}
