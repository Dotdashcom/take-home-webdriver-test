package pages.Tests;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.NewWindow;

public class TC11_NewWindowTest extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup2();
	}
	

	@Test
	public void ValidateUserisOnNewWindow() {
		NewWindow.NavigateToContextMenuPage();
		NewWindow.ClickLinkAndGotoNewWindow();
		String Text = NewWindow.GetTextInNewWindow();
		Assert.assertTrue("new tab is opened with text "+ " " + Text,Text.contains("New Window"));
		
	}

}
