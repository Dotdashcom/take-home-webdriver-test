package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.IframePage;

public class IframeTest extends GenericPage {
	IframePage iframePage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/iframe");
		iframePage = new IframePage();
	}

	@Test
	public void tcIframe() throws InterruptedException {
        Assert.assertEquals(iframePage.getIframeText(), "Your content goes here.");
	}
}