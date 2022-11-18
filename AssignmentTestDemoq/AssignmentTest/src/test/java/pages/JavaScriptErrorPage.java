package pages;

import org.testng.Assert;

import helper.WebHelper;

public class JavaScriptErrorPage {
	private WebHelper helper;
	

		public JavaScriptErrorPage( WebHelper helper) {		
			this.helper=helper;
			
		}
		
		public void VerifyJsError(String text) {
			Assert.assertTrue(helper.JsLogEntry(text));
		}
}
