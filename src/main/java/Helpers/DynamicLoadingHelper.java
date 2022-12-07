package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.DynamicLoadingPage;
public class DynamicLoadingHelper extends Helper {
	DynamicLoadingPage dynamicLoadingPage;
	public DynamicLoadingHelper (Config testConfig) {
		super(testConfig);
		openDynamicLoadingPage();
	}
	public void openDynamicLoadingPage() {
		String dynamicLoadingPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("DynamicLoadingPage");
		Browser.openPageUrl(testConfig, dynamicLoadingPageUrl);
		dynamicLoadingPage = new DynamicLoadingPage(testConfig);
	}
	public void clickStartButton() {
		dynamicLoadingPage.clickStartButton();
	}
	public void verifyLoadingBar() {
		Logger.AssertEqualAndLog("Verifying loading bar is displayed", dynamicLoadingPage.verifyLoadingBar(), true);
	}
	public void verifySuccessMessage(String successMessage) {
		Logger.AssertEqualAndLog("Success message after loading " + successMessage, dynamicLoadingPage.getMessageAfterLoading(), successMessage);
	}
}
