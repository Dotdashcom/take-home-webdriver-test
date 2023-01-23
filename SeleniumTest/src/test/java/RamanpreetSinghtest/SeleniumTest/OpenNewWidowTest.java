package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OpenInnewtabPage;
import TestComponents.BaseTest;

public class OpenNewWidowTest extends BaseTest {

	@Test
	public void newWindow() throws InterruptedException {
		OpenInnewtabPage openinnewtabpage = landingpage.getnewwindowPage();
		String newWinMessage = openinnewtabpage.openNewWindow();
		Assert.assertEquals(newWinMessage, "New Window");

	}

}
