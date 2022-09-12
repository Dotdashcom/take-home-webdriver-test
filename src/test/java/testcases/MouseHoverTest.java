package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.MouseHoverPage;

public class MouseHoverTest {
	
	@Test
	public void MouseHover() {
		Page.initConfiguration("hovers");
		MouseHoverPage mp = new MouseHoverPage();
		mp.verifyMouseHover();
		Page.quitBrowser();
	}

}
