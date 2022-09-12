package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import pages.actions.CheckboxesPage;

public class CheckboxesTest {
	
	@Test
	public void checkboxCheck() {
		
		Page.initConfiguration("checkboxes");
		CheckboxesPage cp = new CheckboxesPage();
		cp.checkCheckbox2();
		cp.checkCheckbox1();
		cp.verifyCheckbox1IsSelected();
		cp.checkCheckbox2();
		cp.verifyCheckbox2IsSelected();
		Page.quitBrowser();
	}

}
