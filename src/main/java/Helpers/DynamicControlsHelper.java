package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.DynamicControlsPage;
public class DynamicControlsHelper extends Helper {
	DynamicControlsPage dynamicControlsPage;
	public DynamicControlsHelper (Config testConfig) {
		super(testConfig);
		openDynamicControlsPage();
	}
	public void clickCheckBoxButton(String buttonText) {
		Logger.AssertEqualAndLog("Verying text on button " + buttonText, dynamicControlsPage.checkBoxButtonText(), buttonText);
		dynamicControlsPage.clickCheckBoxButton();
		Logger.AssertEqualAndLog("Verifying loading is displayed", dynamicControlsPage.isLoadingDisplayed(), true);
		dynamicControlsPage.waitForMessage();
	}
	public void clickTextBoxButton(String buttonText) {
		Logger.AssertEqualAndLog("Verying text on button " + buttonText, dynamicControlsPage.textBoxButtonText(), buttonText);
		dynamicControlsPage.clickTextBoxButton();
		Logger.AssertEqualAndLog("Verifying loading is displayed", dynamicControlsPage.isLoadingDisplayed(), true);
		dynamicControlsPage.waitForMessage();
	}
	public void openDynamicControlsPage() {
		String dynamicControlsPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("DynamicControlsPage");
		Browser.openPageUrl(testConfig, dynamicControlsPageUrl);
		dynamicControlsPage = new DynamicControlsPage(testConfig);
	}
	public void verifyCheckBox(boolean isVisible, String message) {
		Logger.AssertEqualAndLog("Verifying visibility of checkbox", dynamicControlsPage.isCheckBoxVisible(), isVisible);
		Logger.AssertEqualAndLog("Verifying successful message " + message, dynamicControlsPage.getSuccessMessage(), message);
	}
	public void verifyTextBox(boolean isEnable, String message) {
		Logger.AssertEqualAndLog("Verifying if textbox is enabled", dynamicControlsPage.isTextBoxEnabled(), isEnable);
		Logger.AssertEqualAndLog("Verifying successful message " + message, dynamicControlsPage.getSuccessMessage(), message);
	}
}
