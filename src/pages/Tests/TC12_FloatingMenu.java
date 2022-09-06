package pages.Tests;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import pages.Driver;
import pages.FloatingMenu;

public class TC12_FloatingMenu extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	
	@Test
	public void ValidateFolatinMenuAppearsAfterScroll() {
		FloatingMenu.NavigateToFloatingMenuPage();
		FloatingMenu.ScrollToBottomOfThePage();
		Assert.assertTrue(FloatingMenu.ValidatefloatingMenuExists());
	
		
		
	}

}
