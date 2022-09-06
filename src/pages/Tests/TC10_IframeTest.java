package pages.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import pages.Driver;
import pages.Iframe;

public class TC10_IframeTest extends Driver{

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	@Test
	public void ValidateIframeWrittenTest() {
		Iframe.NavigateToIframePage();
		Iframe.SwitchToIframe();
		Iframe.WriteInIframe("Got you!!");
		Assert.assertEquals("Got you!!", Iframe.GetText());
	}

}
