package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.JavaScriptAlertsPage;

public class JavaScriptAlertsTest {
	
	@Test
	public void checkJSAlert() {
		Page.initConfiguration("javascript_alerts");
		JavaScriptAlertsPage jsp = new JavaScriptAlertsPage();
		jsp.verifyJSAlert();
	}
	
	@Test
	public void checkJSConfirm() {
		JavaScriptAlertsPage jsp = new JavaScriptAlertsPage();
		jsp.verifyJSConfirm();
	}
	
	@Test
	public void checkJSPrompt() {
		JavaScriptAlertsPage jsp = new JavaScriptAlertsPage();
		jsp.verifyJSPrompt();
		Page.quitBrowser();
	}

}
