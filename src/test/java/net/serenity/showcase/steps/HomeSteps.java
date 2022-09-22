package net.serenity.showcase.steps;

import net.serenity.showcase.pages.HomePage;
import net.serenity.showcase.utils.Constants;
import net.serenity.showcase.utils.Util;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author : Manish Lalwani
 */

@SuppressWarnings("serial")
public class HomeSteps extends ScenarioSteps {

	private static Logger logger = Logger.getLogger(HomeSteps.class);

	private HomePage homePage;

	/**
	 * Constructor.
	 */
	public HomeSteps(final Pages pages) {
		super(pages);
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
	}

	@Given("the user is in home page")
	public void givenTheUserIsInHomePage() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.open();

	}

	@When("the user navigate to '$textValue'")
	public void theUserNavigateToTextValue(final String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.openAt("/" + textValue);

	}

	@When("the user enter valid username")
	public void theUserEnterValidUserName() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.typeIn("fieldUsername","tomsmith");
	}

	@When("the user enter valid password")
	public void theUserEnterValidPassword() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.typeIn("fieldPassword","SuperSecretPassword!");
	}

	@When("the user enter invalid password")
	public void theUserEnterInValidPassword() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.typeIn("fieldPassword","invalidPassword");
	}

	@When("the user click on login")
	public void theUserClickOnLogin() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonLogin");
	}

	@Then("login should be successful")
	public void loginShouldBeSuccessful() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementOnPage("buttonLogout");
	}

	@Then("invalid password error should be displayed")
	public void invalidPasswordErrorShouldBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForTextToAppear("Your password is invalid");
	}

	@Then("the user change status of checkbox1")
	public void theUserChangeStatusOfCheckbox1() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.changeCheckboxStatus("checkbox1");
	}

	@Then("the user change status of checkbox2")
	public void theUserChangeStatusOfCheckbox2() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.changeCheckboxStatus("checkbox2");
	}

	@When("the user scroll to bottom of page")
	public void theUserScrollToBottomOfPage() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.scrollToBottom();
	}

	@Then("'$textValue' text should be displayed on alert upon context click")
	public void textShouldBeDisplayedOnAlertUponContextClick(String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.contextClick("fieldHotspot");
		String expected = textValue;
		String actual = homePage.getAlertText();
		Assert.assertTrue("Text on alert is incorrect", actual.contains(expected));
	}

	@When("user should perform drag and drop")
	public void userShouldPerformDragAndDrop() throws IOException {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.performDragAndDrop();
	}

	@Then("text on columns should be changed")
	public void textOnColumnsShouldBeChanged() throws IOException {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");

		String expected = "B";
		String actual = homePage.getTextOf("columnAText");
		Assert.assertTrue("Drag and Drop didn't worked !", actual.equals(expected));
	}

	@Then("user should select '$textValue' from dropdown")
	public void userShouldPerformDragAndDrop(String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.selectFromDropdown("selectDropdown", textValue);
	}

	@Then("user should see content changes with page reload")
	public void userShouldSeeContentChangesWithPageReload() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String textBeforeReload = homePage.getTextOf("dynamicContent");
		homePage.clickOn("buttonClickHere");
		String textAfterReload = homePage.getTextOf("dynamicContent");

		Assert.assertFalse("Page content should change after reload !", textAfterReload.equals(textBeforeReload));
	}

	@When("user click on Remove button")
	public void userClickOnRemoveButton() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonRemove");
	}

	@When("user wait for completion of async command")
	public void userWaitForCompletionOfasyncCommand() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementToDisappear("buttonRemove");
	}

	@Then("Add button should be displayed")
	public void addButtonShouldBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementOnPage("buttonAdd");
	}

	@Then("success message should be displayed")
	public void successMessageShouldBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String expected = "It's gone!";
		String actual = homePage.getTextOf("textMessageAddRemove");
		Assert.assertTrue("Its gone should be displayed !", actual.contains(expected));
	}

	@When("user click on Start button")
	public void userClickOnStartButton() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonStart");
	}

	@When("user wait for loading to complete")
	public void userWaitForLoadingToComplete() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementToDisappear("textLoading");
	}

	@Then("'$textValue' message should be displayed")
	public void textValueMessageShouldBeDisplayed(String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForTextToAppear(textValue);
	}

	@When("user upload the file")
	public void userUploadTheFile() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.uploadFile("buttonChooseFile");
	}

	@When("the user click on Upload button")
	public void theUserClickOnUploadButton() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonFileUpload");
	}

	@Then("file uploaded successfully message should be displayed")
	public void fileUploadedSuccessfullyMessageShouldBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementOnPage("fileUploadSuccessMessage");
	}

	@Then("floating menu should still be displayed")
	public void floatingMenuShouldStillBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.waitForElementOnPage("floatingMenu");
	}

	@When("the user switch to iframe '$textValue'")
	public void theUserSwitchToIframe(final String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.switchToIframe(textValue);
	}

	@Then("user should be able to enter text on iframe")
	public void userShouldBeAbleToEnterTextOnIframe() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.typeIn("iframeBody", "Testing iFrame by Manish");
	}

	@Then("additional information should be displayed upon mouse hover")
	public void additionalInformationShouldBeDisplayedUponMouseHover() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.mouseHover("hover");
		homePage.waitForElementOnPage("hoverText");
	}

	@When("the user '$textValue'")
	public void theUserClickTextValue(final String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonJavascriptAlerts", textValue);
	}

	@Then("'$textValue' text should be displayed on Alert")
	public void textValueTextShouldBeDisplayedOnAlert(final String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String expected = textValue;
		String actual = homePage.getAlertText();
		Assert.assertTrue("Text on alert is incorrect", actual.contains(expected));
	}

	@Then("'$textValue' text should be displayed on Alert upon click on '$button'")
	public void textValueTextShouldBeDisplayedOnAlert(final String textValue, final String button) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickByJS("buttonJavascriptAlerts", button);
		String expected = textValue;
		String actual = homePage.getAlertText();
		Assert.assertTrue("Text on alert is incorrect", actual.contains(expected));
	}

	@When("the user press Enter")
	public void theUserPressEnter() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.pressEnter();
	}

	@When("user enter text on JS prompt upon click on '$textValue'")
	public void userEnterTextOnJSPromptUponClickOn(final String textValue) {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickByJS("buttonJavascriptAlerts", textValue);
		homePage.typeInAlert("Testing");
	}

	@Then("text should be entered successfully")
	public void textShouldBeEnteredSucessfully() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String expected = "Testing";
		String actual = homePage.getTextOf("jsAlertResult");
		Assert.assertTrue("Text on alert not saved !", actual.contains(expected));
	}

	@Then("javascript error should be displayed in console")
	public void javascriptErrorShouldBeDisplayedInConsole() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String expected = "Failed to load resource: the server responded with a status of 404 (Not Found)";
		String actual = homePage.getJavascriptError();
		Assert.assertTrue("Javascript error is not correct !", actual.contains(expected));
	}


	@When("the user click here to switch to new tab")
	public void theUserClickHereToSwitchToNewTab() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonClickHereForNewTab");
	}

	@Then("new tab should be launched")
	public void newTabShouldBeLaunched() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.switchToTab(1);
		homePage.waitForTextToAppear("New Window");
	}

	@When("the user Click here to load notification message")
	public void theUserClickHereToLoadNotificationMessage() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("buttonClickHereForNotification");
	}

	@Then("notification message should be displayed")
	public void notificationMessageShouldBeDisplayed() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		String expected1 = "Action successful";
		String expected2 = "Action unsuccesful, please try again";
		String expected3 = "Action Unsuccessful";
		String actual = homePage.getTextOf("flashNotification");
		Assert.assertTrue("Notification message is not displayed !", actual.contains(expected1) | actual.contains(expected2) | actual.contains(expected3));
	}

	@When("the user click on the file to download")
	public void theUserClickOnTheFileToDownload() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		homePage.clickOn("fileDownload");
	}

	@Then("file is downloaded successfully")
	public void fileIsDownloadedSuccessfully() {
		logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
		Boolean actual = homePage.findFileInTargetFolder("some-file");
		Assert.assertTrue("File download failed !", actual);
	}
}
