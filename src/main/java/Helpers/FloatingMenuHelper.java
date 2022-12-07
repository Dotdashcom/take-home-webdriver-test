package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.FloatingMenuPage;
public class FloatingMenuHelper extends Helper {
	FloatingMenuPage floatingMenuPage;
	public FloatingMenuHelper (Config testConfig) {
		super(testConfig);
		openFloatingMenuPage();
	}
	public void openFloatingMenuPage() {
		String FloatingMenuPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("FloatingMenuPage");
		Browser.openPageUrl(testConfig, FloatingMenuPageUrl);
		floatingMenuPage = new FloatingMenuPage(testConfig);
	}
	public void scrollDown() {
		floatingMenuPage.scrollDown();
	}
	public void verifyMenuIsDisplayed() {
		Logger.AssertEqualAndLog("Verifying presence of floating menu", floatingMenuPage.isMenuDisplayed(), true);
	}
}
