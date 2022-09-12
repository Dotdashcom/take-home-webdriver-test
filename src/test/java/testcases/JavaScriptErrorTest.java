package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import pages.actions.JavaScripErrorPage;

public class JavaScriptErrorTest {

	
	@Test
	public void JSError() {
		Page.initConfiguration("javascript_error");
		JavaScripErrorPage jep = new JavaScripErrorPage();
		jep.findJSError();
		Page.quitBrowser();
		
	}
}
