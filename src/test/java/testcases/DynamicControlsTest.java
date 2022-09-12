package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.DynamicControlsPage;

public class DynamicControlsTest {

	@Test(priority = 1)
	public void VerifyCheckboxisGone() {
		Page.initConfiguration("dynamic_controls");
		DynamicControlsPage dcp = new DynamicControlsPage();
		dcp.verifyCheckboxIsGone();
	}

	@Test(priority = 2)
	public void VerifyCheckboxisPresent() {
		DynamicControlsPage dcp = new DynamicControlsPage();
		dcp.verifyCheckboxIsPresent();

	}

	@Test(priority = 3)
	public void VerifyEnableBtn() {
		DynamicControlsPage dcp = new DynamicControlsPage();
		dcp.verifyEnableButton();

	}

	@Test(dependsOnMethods = {"VerifyEnableBtn"})
	public void VerifyDisableBtn() {
		DynamicControlsPage dcp = new DynamicControlsPage();
		dcp.verifyDisableButton();
		Page.quitBrowser();
	}

}
