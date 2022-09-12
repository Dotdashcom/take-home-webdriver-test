package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.DynamicLoadingPage;

public class DynamicLoadingTest {
	
	@Test
	public void DynamicLoading() {
		Page.initConfiguration("dynamic_loading/2");
		DynamicLoadingPage dlp = new DynamicLoadingPage();
		dlp.verifyStartButton();
		Page.quitBrowser();
	}

}
