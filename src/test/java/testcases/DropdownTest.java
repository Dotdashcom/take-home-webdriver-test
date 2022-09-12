package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import pages.actions.DropdownPage;

public class DropdownTest {
	
	@Test
	public void dropdown() {
		Page.initConfiguration("dropdown");
		DropdownPage drp = new DropdownPage();
		drp.selectOption("Option 1");
		drp.iSeeInDropdown("Option 1");
		drp.selectOption("Option 2");
		drp.iSeeInDropdown("Option 2");
		Page.quitBrowser();
		
	}

}
