package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.OpenInNewTabPage;

public class OpenInNewTabTest {
	
	@Test
	public void newWndowCheck() {
		Page.initConfiguration("windows");
		OpenInNewTabPage op = new OpenInNewTabPage();
		op.verifyNewWindow();
		Page.quitBrowser();
		
	}

}
