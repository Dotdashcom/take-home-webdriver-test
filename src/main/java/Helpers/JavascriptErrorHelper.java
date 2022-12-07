package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.JavaScriptErrorPage;
public class JavascriptErrorHelper extends Helper {
	JavaScriptErrorPage javaScriptErrorPage;
	public JavascriptErrorHelper (Config testConfig) {
		super(testConfig);
		openJavaScriptErrorPage();
	}
	public void openJavaScriptErrorPage() {
		String javaScriptErrorPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("JavaScriptErrorPage");
		Browser.openPageUrl(testConfig, javaScriptErrorPageUrl);
		javaScriptErrorPage = new JavaScriptErrorPage(testConfig);
	}
	public void verifyJsError(String jsErrorMessage) {
		Logger.AssertContainsAndLog("Verifying js error message - " + jsErrorMessage, javaScriptErrorPage.getJsError(), jsErrorMessage);
	}
}
