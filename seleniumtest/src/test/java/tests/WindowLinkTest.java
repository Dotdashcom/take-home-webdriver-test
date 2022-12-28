package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.WindowLinkPage;

public class WindowLinkTest extends GenericPage {
	WindowLinkPage windowLinkPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/windows");
		windowLinkPage = new WindowLinkPage();
	}

	@Test
	public void tcWindowLink() throws InterruptedException {
		Assert.assertTrue(windowLinkPage.getNewTab());
	}
}