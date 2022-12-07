package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.OpenNewTabPage;
public class OpenNewTabHelper extends Helper {
	OpenNewTabPage openNewTabPage;
	public OpenNewTabHelper (Config testConfig) {
		super(testConfig);
		openNewTabPage();
	}
	public void openNewTabPage() {
		String newTabPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("OpenNewTabPage");
		Browser.openPageUrl(testConfig, newTabPageUrl);
		openNewTabPage = new OpenNewTabPage(testConfig);
	}
	public void clickToOpenNewTabAndSwitch() {
		openNewTabPage.clickToOpenNewTabAndSwitch();
	}
	public void verifyNewTab(String textOnNewTab) {
		Logger.AssertEqualAndLog("Verifying text on new tab " + textOnNewTab, openNewTabPage.getTextFromNewTab(), textOnNewTab);
	}
}
