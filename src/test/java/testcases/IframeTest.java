package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.IframePage;

public class IframeTest {
	
	@Test
	public void Iframe() {
		Page.initConfiguration("iframe");
		IframePage iframe = new IframePage();
		iframe.verifyIframe();
		Page.quitBrowser();
	}

}
