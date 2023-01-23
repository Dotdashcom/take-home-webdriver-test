package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.JavaScriptErrorPage;
import TestComponents.BaseTest;

public class JavaScriptErrorTest extends BaseTest {

	@Test
	public void JSErrortest() throws InterruptedException {

		JavaScriptErrorPage javascripterrortest = landingpage.getJSErrorPage();
		boolean result = javascripterrortest.getJavascriptError();
		Assert.assertTrue(result);
	}

}
