package pages.Tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.ContextMenu;

public class TC5_ContextMenu {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}
	
	@Test
	public void ValidateRightClick() {
		ContextMenu.NavigateToContextMenuPage();
		ContextMenu.RightClickBox();
		Assert.assertTrue(ContextMenu.HandleAlertAndGetText().contains("You selected a context menu"));
		
	}

}
