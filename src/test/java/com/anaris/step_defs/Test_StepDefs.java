package com.anaris.step_defs;

import com.anaris.pages.TestPage;
import com.anaris.utilities.BrowserUtils;
import com.anaris.utilities.ConfigurationReader;
import com.anaris.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test_StepDefs {

    TestPage testPage = new TestPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Actions actions = new Actions(Driver.getDriver());

    Alert alert;

    @Given("User on the web page")
    public void user_on_the_web_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url.test"));
    }

    @When("Checkboxes page is launched")
    public void checkboxesPageIsLaunched() {
        testPage.linkCheckboxes.click();
    }

    @When("User checks the checkboxes")
    public void user_checks_the_checkboxes() {

        testPage.checkBoxes();
    }

    @Then("Checkboxes are checked")
    public void checkboxes_are_checked() {

        for (WebElement each : testPage.checkBoxesList) {
            Assert.assertTrue("Failed", each.isSelected());
        }
    }

    /**
     *    Context Menu
     */

    @When("Context Menu page is launched")
    public void context_menu_page_is_launched() {
        testPage.linkContextMenu.click();
    }

    @When("User does right click on the square")
    public void user_does_right_click_on_the_square() {

        actions.contextClick(testPage.rightClickContext).build().perform();

    }

    @Then("The Context Menu is displayed")
    public void the_context_menu_is_displayed() {

        Alert alert = Driver.getDriver().switchTo().alert();
        String actualContextMsg = alert.getText();
        String expectedContextMsg = "You selected a context menu";
        alert.accept();
        Assert.assertEquals("Failed", expectedContextMsg, actualContextMsg);

    }

    /**
     *    Drag and Drop
     */

    @When("Drag and Drop page is launched")
    public void dragAndDropPageIsLaunched() {

        testPage.linkDragDrop.click();

    }

    @And("User drags element A to element B")
    public void userDragsElementAToElementB() {

        actions.clickAndHold(testPage.columnA).moveToElement(testPage.columnB)
                .release().build().perform();

    }

    @Then("User asserts that the text on element A and B are switched")
    public void userAssertsThatTheTextOnElementAAndBAreSwitched() {

        Assert.assertEquals("Failed", "A", testPage.columnB.getText());
        Assert.assertEquals("Failed", "B", testPage.columnA.getText());
    }


    /**
     *    Dropdown
     */

    @When("Dropdown page is launched")
    public void dropdownPageIsLaunched() {

        testPage.linkDropdown.click();
    }

    @Then("User asserts {string} and {string} are selected")
    public void userAssertsAndAreSelected(String option1, String option2) {

        Assert.assertEquals("Failed", option1, testPage.dropdownVerify(testPage.selectDropdown).get(1));
        Assert.assertEquals("Failed", option2, testPage.dropdownVerify(testPage.selectDropdown).get(2));

    }


    /**
     *    Dynamic Content
     */

    @When("Dynamic Content page is launched")
    public void dynamicContentPageIsLaunched() {

        testPage.linkDynCont.click();

    }

    String previousContent;

    @And("User refreshes the page a couple of times")
    public void userRefreshesThePageACoupleOfTimes() {

        previousContent = testPage.lastContent.getText();
        Driver.getDriver().navigate().refresh();

    }

    @Then("User asserts that the content changes on each refresh")
    public void userAssertsThatTheContentChangesOnEachRefresh() {

        Assert.assertNotEquals("Failed", previousContent, testPage.lastContent.getText());

    }


    /**
     *    Dynamic Controls
     */


    @When("Dynamic Controls page is launched")
    public void dynamicControlsPageIsLaunched() {

        testPage.linkDynControls.click();
    }

    @And("User clicks on the Remove Button and uses explicit wait")
    public void userClicksOnTheRemoveButtonAndUsesExplicitWait() {

        Assert.assertTrue(testPage.checkBox.isDisplayed());
        testPage.removeBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.addBtn));
    }

    @Then("User asserts that the checkbox is gone")
    public void userAssertsThatTheCheckboxIsGone() {

        Assert.assertEquals("Failed", "It's gone!", testPage.goneMsg.getText());
    }

    @And("User clicks on Add Button and uses explicit wait")
    public void userClicksOnAddButtonAndUsesExplicitWait() {

        testPage.addBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.removeBtn));
    }

    @Then("User asserts that the checkbox is present")
    public void userAssertsThatTheCheckboxIsPresent() {

        Assert.assertTrue("Failed", testPage.checkBox.isDisplayed());
    }

    @And("User clicks on the Enable Button and uses explicit wait")
    public void userClicksOnTheEnableButtonAndUsesExplicitWait() {

        testPage.enableBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.disableBtn));
    }

    @Then("User asserts that the text box is enabled")
    public void userAssertsThatTheTextBoxIsEnabled() {

        Assert.assertTrue("Failed", testPage.textBox.isEnabled());
        Assert.assertEquals("Failed", "It's enabled!", testPage.goneMsg.getText());
    }

    @And("User clicks on the Disable Button and uses explicit wait")
    public void userClicksOnTheDisableButtonAndUsesExplicitWait() {

        testPage.disableBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.enableBtn));
    }

    @Then("User asserts that the text box is disabled")
    public void userAssertsThatTheTextBoxIsDisabled() {

        Assert.assertFalse(testPage.textBox.isEnabled());
        Assert.assertEquals("Failed", "It's disabled!", testPage.goneMsg.getText());
    }


    /**
     *    Dynamic Loading
     */

    @When("Dynamic Loading page is launched")
    public void dynamicLoadingPageIsLaunched() {

        testPage.linkDynLoading.click();
        testPage.firstExample.click();
    }

    @When("User clicks the start button and uses explicit wait")
    public void userClicksTheStartButtonAndUsesExplicitWait() {

        testPage.startBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.finishMsg));
    }

    @Then("User asserts that “Hello World!” text is displayed.")
    public void userAssertsThatHelloWorldTextIsDisplayed() {

        Assert.assertEquals("Failed", "Hello World!", testPage.finishMsg.getText());
    }


    /**
     *    File Download
     */


    @When("File Download page is launched")
    public void fileDownloadPageIsLaunched() {

        testPage.linkFileDownload.click();
    }

    @And("User clicks on the file")
    public void userClicksOnTheFile() {

        testPage.downloadFile.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.downloadFile));
    }

    @Then("User asserts that the file is downloaded")
    public void userAssertsThatTheFileIsDownloaded() {

        Assert.assertEquals("Failed", "some-file.txt", testPage.verifyDownloadedFile(testPage.downloadFile.getText()));

    }


    /**
     *    File Upload
     */

    @When("File Upload page is launched")
    public void fileUploadPageIsLaunched() {

        testPage.linkFileUpload.click();
    }

    @And("User uses Upload Button or Drag and Drop to upload a file")
    public void userUsesUploadButtonOrDragAndDropToUploadAFile() {

        String path = "C:\\Users\\TRIADA\\Downloads\\some-file.txt";
        testPage.chooseFileBtn.sendKeys(path);
        testPage.uploadBtn.click();
        wait.until(ExpectedConditions.visibilityOf(testPage.verifyMessage));
    }

    @Then("User asserts that the file is uploaded")
    public void userAssertsThatTheFileIsUploaded() {

        Assert.assertEquals("Failed", "File Uploaded!", testPage.verifyMessage.getText());
    }


    /**
     *    Floating Menu
     */

    @When("Floating Menu page is launched")
    public void floatingMenuPageIsLaunched() {

        testPage.linkFloatMenu.click();
    }

    @And("User scrolls the page")
    public void userScrollsThePage() {

        Assert.assertTrue(testPage.menuModules.isDisplayed());
        actions.moveToElement(testPage.scrollToElement).build().perform();
    }

    @Then("User asserts that the floating menu is still displayed")
    public void userAssertsThatTheFloatingMenuIsStillDisplayed() {

        Assert.assertTrue("Failed", testPage.menuModules.isDisplayed());
    }


    /**
     *    Iframe
     */

    @When("Iframe page is launched")
    public void iframePageIsLaunched() {

        testPage.linkFrames.click();
    }

    String expectedText;

    @And("User switches to Iframe and types some text")
    public void userSwitchesToIframeAndTypesSomeText() {

        testPage.clickIFrame.click();
        Driver.getDriver().switchTo().frame(testPage.iframe);
        testPage.sendText.clear();
        expectedText = Faker.instance().artist().name();
        testPage.sendText.sendKeys(expectedText);
    }

    @Then("User asserts that the typed text is as expected")
    public void userAssertsThatTheTypedTextIsAsExpected() {

        Assert.assertEquals("Failed",expectedText, testPage.sendText.getText());
    }


    /**
     *    Mouse Hover
     */

    @When("Mouse Hover page is launched")
    public void mouseHoverPageIsLaunched() {

        testPage.linkHover.click();
    }

    @And("User does a mouse hover on each image")
    public void userDoesAMouseHoverOnEachImage() {

        testPage.hoverTexts();
    }

    @Then("User asserts that additional information is displayed for each image")
    public void userAssertsThatAdditionalInformationIsDisplayedForEachImage() {

        Assert.assertTrue("Failed",testPage.hoverImages());
    }


    /**
     *    JavaScript Alerts
     */

    @When("JavaScript Alerts page is launched")
    public void javascriptAlertsPageIsLaunched() {

        testPage.linkJSAlerts.click();
    }

    @And("User Clicks on JS Alert Button")
    public void userClicksOnJSAlertButton() {

        testPage.jsAlertBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("User asserts alert message")
    public void userAssertsAlertMessage() {

        Assert.assertEquals("Failed","You successfuly clicked an alert",testPage.jsAlertMsg.getText());

    }

    @And("User clicks on JS confirm Button and clicks ok on alert")
    public void userClicksOnJSConfirmButtonAndClicksOkOnAlert() {

        testPage.jsConfirmBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("User asserts the alert message")
    public void userAssertsTheAlertMessage() {

        Assert.assertEquals("Failed","You clicked: Ok",testPage.jsAlertMsg.getText());
    }

    @When("User clicks on JS Prompt Button and types a message on Prompt")
    public void userClicksOnJSPromptButtonAndTypesAMessageOnPrompt() {

        testPage.jsPromptBtn.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Baku");
        alert.accept();
    }

    @Then("User asserts that the alert message contains the typed message")
    public void userAssertsThatTheAlertMessageContainsTheTypedMessage() {

        Assert.assertEquals("Failed","You entered: Baku",testPage.jsAlertMsg.getText());
    }


    /**
     *    JavaScript Error
     */

    @When("JavaScript Error page is launched")
    public void javascriptErrorPageIsLaunched() {

        testPage.linkJSError.click();
    }

    @And("User finds the JavaScript error on the page")
    public void userFindsTheJavaScriptErrorOnThePage() {

        System.out.println(testPage.jsErrorMsg.getText());
    }

    @Then("User asserts that the page contains error: Cannot read property xyz of undefined")
    public void userAssertsThatThePageContainsErrorCannotReadPropertyXyzOfUndefined() {

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("logEntries.getAll() = " + logEntries.getAll());

        Assert.assertTrue("Failed",logEntries.getAll().get(1).toString().contains("Cannot read properties of undefined (reading 'xyz')"));

    }


    /**
     *    Open in New Tab
     */

    @When("Open in New Tab page is launched")
    public void openInNewTabPageIsLaunched() {

        testPage.linkMultiTabs.click();
    }

    @And("User clicks on the Click Here link")
    public void userClicksOnTheClickHereLink() {

        testPage.clickHereBtn.click();
    }

    @Then("User asserts that a new tab is opened with text New Window")
    public void userAssertsThatANewTabIsOpenedWithTextNewWindow() {

        testPage.openNewTab();
        Assert.assertEquals("Failed","New Window",testPage.newTabMsg.getText());

    }


    /**
     *    Notification Message
     */

    @When("Notification Message page is launched")
    public void notificationMessagePageIsLaunched() {

        testPage.linkNotifyMsg.click();
    }

    @And("User clicks on the Click Here link a multiple times")
    public void userClicksOnTheClickHereLinkAMultipleTimes() {

        testPage.notifyClickHereBtn.click();
    }
    @Then("User asserts that one of the {string}, {string}, {string} messages show on click")
    public void userAssertsThatOneOfTheMessagesShowOnClick(String arg0, String arg1, String arg2) {

        String notifyMsg = testPage.notifyMsg.getText().replace('×',' ').trim();

        List<String> list = new ArrayList<>(Arrays.asList(arg0,arg1,arg2));

        Assert.assertTrue("Failed",list.contains(notifyMsg));
    }
}
