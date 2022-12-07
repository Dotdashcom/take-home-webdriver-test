package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.ContextMenuPage;
public class ContextMenuHelper extends Helper {
	ContextMenuPage contextMenuPage;
	public ContextMenuHelper (Config testConfig) {
		super(testConfig);
		openContextMenuPage();
	}
	public void clickHotSpot() {
		contextMenuPage.clickHotSpot();
	}
	public void openContextMenuPage() {
		String contextMenuPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("ContextMenuPage");
		Browser.openPageUrl(testConfig, contextMenuPageUrl);
		contextMenuPage = new ContextMenuPage(testConfig);
	}
	public void verifyAlert(String alertText) {
		Logger.AssertEqualAndLog("Verifying alert message " + alertText, contextMenuPage.getAlertText(), alertText);
	}
}
