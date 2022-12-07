package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.IframePage;
public class IframeHelper extends Helper {
	IframePage iframePage;
	public IframeHelper (Config testConfig) {
		super(testConfig);
		openIframePage();
	}
	public void openIframePage() {
		String iframePageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("IframePage");
		Browser.openPageUrl(testConfig, iframePageUrl);
		iframePage = new IframePage(testConfig);
	}
	public void addText(String text) {
		iframePage.addText(text);
	}
	public void verifyAddedText(String text) {
		Logger.AssertEqualAndLog("Verifying text " + text, iframePage.getAddedTest(), text);
	}
}
