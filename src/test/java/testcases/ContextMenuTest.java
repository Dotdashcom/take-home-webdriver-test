package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.ContextMenuPage;

public class ContextMenuTest {
	
	@Test
	public void contextMenu() {
		Page.initConfiguration("context_menu");
		ContextMenuPage cop = new ContextMenuPage();
		cop.rightClickOnContextMenu();
		cop.verifyAlertMenuText();
		Page.quitBrowser();
	}

}
