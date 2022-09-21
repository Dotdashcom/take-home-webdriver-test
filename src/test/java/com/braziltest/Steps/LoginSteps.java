package com.braziltest.Steps;

import com.braziltest.Pages.LoginPage;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.braziltest.Utils.Config.PathOrigin;
import static com.braziltest.Utils.Config.pSit;
import static com.braziltest.utils.ProcessBuilderRun.processCommand;

public class LoginSteps extends BaseStep {

    @Given("^that the user is on the home screen \"([^\"]*)\"$")
    public void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        LoginPage.thatTheUserIsOnTheHomeScreen(arg0);
    }

    @And("validate result \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateResult(String type, String arg0,String Result) throws Exception {
        LoginPage.validateResult(type,arg0,Result);
    }

    @And("Click Login")
    public void clickLogin() {
    }

    @And("Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterAnd(String arg0, String arg1) throws IOException {
        LoginPage.SendCredentials(arg0,arg1);
    }

    @After
    public void teardownSteps() throws Exception {
        Webdriver.quit();
    }

    @And("test checks and unchecks checkboxes \"([^\"]*)\"$")
    public void checkCheckboxes(String arg0) {
        LoginPage.checkCheckBoxes(arg0);
    }

    @Given("test right click on context menu")
    public void testRightClickOnContextMenu() {
        LoginPage.contextMenu(Webdriver);
    }

    @And("test drags element A to element B \"([^\"]*)\"$")
    public void estDragsElementAToElementB(int arg0) {
        Instrumentation.dragAndDrop(Webdriver,arg0);
    }

    @And("select doropdopwn \"([^\"]*)\"$")
    public void selectDoropdopwn(String arg0) {
        LoginPage.selectDoropdown(Webdriver,arg0);
    }

    @And("Test refreshes the page a couple of times \"([^\"]*)\"$")
    public void testRefreshesThePageACoupleOfTimes(int arg0) throws IOException, InterruptedException {
        LoginPage.testRefresh(Webdriver,arg0);
    }

    @And("Test clicks on the Remove Button and uses explicit wait \"([^\"]*)\"$")
    public void testClicksOnTheRemoveButtonAndUsesExplicitWait(String arg0) throws IOException {
        LoginPage.ClicksOnREmoveButton(Webdriver,arg0);
    }

    @And("Test clicks on Add Button")
    public void testClicksOnAddButtonAndUsesExplicitWait() throws IOException {
        LoginPage.ClicksOnAddButton(Webdriver);
    }

    @And("Test clicks on the Enable Button")
    public void testClicksOnTheEnableButton() throws IOException {
        LoginPage.ClicksOnEnableButton(Webdriver);
    }

    @And("Test clicks on the Disabled Button")
    public void testClicksOnTheDisabledButton() throws IOException {
        LoginPage.ClicksOnDisableButton(Webdriver);
    }



    @And("Test clicks the start button")
    public void testClicksTheStartButton() throws IOException {
        LoginPage.ClicksTheStartButton(Webdriver);
    }

    @And("Test clicks file download")
    public void testClicksFileDownload() throws IOException {
        LoginPage.ClickFileDownload(Webdriver);
    }

    @And("Test clicks file upload \"([^\"]*)\"$")
    public void testClicksFileUpload(String arg0) throws IOException {
        LoginPage.UploadFile(Webdriver,arg0);
    }

    @And("Test scrollpage")
    public void testScrollpage() {
        LoginPage.testScrollPage(Webdriver);
    }

    @And("Test switch to iframe")
    public void testSwitchToIframe() throws IOException {
        LoginPage.switchIframe(Webdriver);
    }

    @And("Test does a mouse hover on each image \"([^\"]*)\"$")
    public void testDoesAMouseHoverOnEachImage(String arg0) {
        LoginPage.mouseHover(Webdriver,arg0);
    }

    @And("Test Clicks on JS Alert Button \"([^\"]*)\"$")
    public void testClicksOnJSAlertButton(String arg0) throws IOException {
        LoginPage.ClicksOnJSAlertButton(Webdriver,arg0);
    }

    @And("Test finds the JavaScript error on the page \"([^\"]*)\"$")
    public void testFindsTheJavaScriptErrorOnThePage(String arg0) {
        LoginPage.testFindsTheJavaScriptErrorOnThePage(Webdriver,arg0);
    }

    @And("Test clicks on the Click Here link")
    public void testClicksOnTheClickHereLink() throws IOException, InterruptedException {
        LoginPage.testClicksOnTheClickHereLink(Webdriver);
    }

    @And("Test Click Here link a multiple times \"([^\"]*)\"$")
    public void testClicksOnTheClickHereLinkAMultipleTimes(String arg0) throws IOException, InterruptedException {
        LoginPage.testClicksOnTheClickHereLinkAMultipleTimes(Webdriver,arg0);
    }
}
