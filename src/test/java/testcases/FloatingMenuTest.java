package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.FloatingMenuPage;

public class FloatingMenuTest {
	
	@Test
	public void floatingMenuCheck() {
		Page.initConfiguration("floating_menu");
		FloatingMenuPage fp = new FloatingMenuPage();
		fp.verifyScrolling();
		Page.quitBrowser();
	}

}
