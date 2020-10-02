package com.TestCases;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Binding the listener class to the test case- disabled for now
//@Listeners(com.Listener.TestListener.class)
public class DotDashSeleniumTest extends TestEngine {

    //soft assertion object initialisation
    @BeforeMethod
    public  void SoftAssertInitialisation() {
        softassert = new SoftAssert();
    }

    public void LoadUrl(String _componentName){
        driver.get(_baseUrl + _componentName);
        SeleniumCommonMethods.waitForLoad(driver);

    }
    /*
    1. Login Success
    Page Object Model for the login page should be provided.
    Test is able to login successfully.
    Test uses an assertion to make sure User has logged in. */

    @Test(priority = 1)
    public void LoginSuccess(){
        LoadUrl("login");
        SeleniumCommonMethods.WaitUntilElementAppears(logInPage._loginButton);
        //Input valid credentials and login
        logInPage.EnterUserName(_validUserName);
        logInPage.EnterPassWord(_validPassWord);
        logInPage.ClickLogin();
        //wait till page is loaded
        SeleniumCommonMethods.WaitUntilElementAppears(logInPage._logoutButton);
        // Test uses an assertion to make sure User has logged in
        Assert.assertTrue(logInPage.LogInSuccessIsDisplayed(),"LogIn has failed. Please check credentials.");
        // Assert.assertTrue(logInPage.LogOutButtonIsDisplayed(),"Login has failed. Please check credentials.");

        //Navigate backs to Login Page
        logInPage.ClickLogout();
        SeleniumCommonMethods.WaitUntilElementAppears(logInPage._loginButton);
    }

    /*
    2. Login Failure
    Page Object Model for the login page should be used.
    Test is not able to login with wrong credentials.
    Test uses assertions to check Login failed for incorrect user and password.*/

    @Test(priority = 2,dependsOnMethods = "LoginSuccess")
    public void LoginFailure(){
        LoadUrl("login");
        SeleniumCommonMethods.WaitUntilElementAppears(logInPage._loginButton);
        //Input invalid credentials and try login
        logInPage.LoginViaInvalidCredentials(_invalidUserName,_invalidPassWord);
        SeleniumCommonMethods.WaitUntilElementAppears(logInPage._errorMsg);

        //Test uses assertions to check Login failed for incorrect username and password.
        Assert.assertTrue(logInPage.ErrorMessageIsDisplayed(),"Login Passed for invalid credentials ");
    }

    /*
    3. Checkboxes
    Test checks and unchecks checkboxes.
    Test uses assertions to make sure boxes were properly checked and unchecked.*/

    @Test(priority = 3)
    public void CheckBoxFunctionalityValidation(){
        LoadUrl("checkboxes");
        SeleniumCommonMethods.WaitUntilElementAppears(checkBoxPage._checkBox1);

        //Test checks and unchecks checkboxes.
        checkBoxPage.ClickCheckBox1();
        checkBoxPage.ClickCheckBox2();

        //Test uses assertions to make sure boxes were properly checked and unchecked
        softassert.assertTrue(checkBoxPage._checkBox1.isSelected());
        softassert.assertFalse(checkBoxPage._checkBox2.isSelected());
        softassert.assertAll("Either checkbox1 is unchecked or checkbox2 is checked- which is unexpected.");
    }

    /*
    4. Context Menu
    Test right clicks on the context menu.
    Test asserts the alert menu text.*/

    @Test(priority = 19)
    public void ContextMenuValidation(){
        LoadUrl("context_menu");
        SeleniumCommonMethods.WaitUntilElementAppears(contextMenuPage._box);
        //Test right clicks on the context menu.
        contextMenuPage.RightClickBox();
        //  Test asserts the alert menu text
        Assert.assertTrue(contextMenuPage._alertMsgExpected.equalsIgnoreCase(contextMenuPage.GetAlertMsgActual()),"Alert menu text is incorrect.");
        contextMenuPage.CloseContextAlert();
    }

    /*
    5. Drag and Drop
    Test drags element A to element B.
    Test asserts that the text on element A and B are switched.*/

    @Test(priority = 5)
    public void DragAndDropFunctionality(){
        LoadUrl("drag_and_drop");
        SeleniumCommonMethods.WaitUntilElementAppears(dragAndDropPage._dragFromLocator);

        // Test drags element A to element B.
        dragAndDropPage.DragAndDropValidation();

        // Test asserts that the text on element A and B are switched.
        Assert.assertTrue(dragAndDropPage.IsDragLocatorTextCorrect(),"Column B should be present in first box.");
        Assert.assertTrue(dragAndDropPage.IsDropLocatorTextCorrect(),"Column A should be present in second box.");
    }

    /*
    6. Dropdown
    Test selects Option 1 and Option 2 from the drop down menu.
    Test asserts Option 1 and Option 2 are selected.*/

    @Test(priority = 6)
    public void DropDownFunctionality(){
        LoadUrl("dropdown");
        SeleniumCommonMethods.WaitUntilElementAppears(dropDownPage._dropDownTextBox);

        //dropdown option 1 validation
        dropDownPage.SelectDropDownOption1();
        Assert.assertTrue(dropDownPage.IsOption1Displayed(),"Drop down option 1 should be selected.");


        //dropdown option 2 validation
        dropDownPage.SelectDropDownOption2();
        Assert.assertTrue(dropDownPage.IsOption2Displayed(),"Drop down option 2 should be selected.");
    }

    /*
    7. Dynamic Content
    Test refreshes the page a couple of times.
    Test asserts that the content changes on each refresh.*/

    @Test(priority = 7)
    public void DynamicContentValidation(){
        LoadUrl("dynamic_content");
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicContentPage._dynamicContent1);

        //Compare results before and after browser refresh
        dynamicContentPage.GetallParagraphText();
        dynamicContentPage.RefreshBrowser();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicContentPage._dynamicContent1);

        softassert.assertFalse(dynamicContentPage._paragraph1Text.equalsIgnoreCase(dynamicContentPage._dynamicContent1.getText().trim()),"Dynamic content 1 should be changed.");
        softassert.assertFalse(dynamicContentPage._paragraph2Text.equalsIgnoreCase(dynamicContentPage._dynamicContent2.getText().trim()),"Dynamic content 2 should be changed ");
        softassert.assertFalse(dynamicContentPage._paragraph3Text.equalsIgnoreCase(dynamicContentPage._dynamicContent3.getText().trim()),"Dynamic content 3 should be changed ");
        softassert.assertAll("Results are not as expected when refreshed.");

        //Compare results before and after static button click
        dynamicContentPage.ClickStaticButton();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicContentPage._dynamicContent1);

        //all three results are changed from previously displayed ones
        dynamicContentPage.RefreshBrowser();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicContentPage._dynamicContent2);

        //to verify if only the last result is changed now
        dynamicContentPage.GetallParagraphText();
        dynamicContentPage.RefreshBrowser();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicContentPage._dynamicContent2);


        softassert.assertTrue(dynamicContentPage._paragraph1Text.equalsIgnoreCase(dynamicContentPage._dynamicContent1.getText().trim()),"Dynamic content 1 should not be changed.-After Static");
        softassert.assertTrue(dynamicContentPage._paragraph2Text.equalsIgnoreCase(dynamicContentPage._dynamicContent2.getText().trim()),"Dynamic content 2 should not be changed -After Static");
        softassert.assertFalse(dynamicContentPage._paragraph3Text.equalsIgnoreCase(dynamicContentPage._dynamicContent3.getText().trim()),"Dynamic content 3 should be changed -After Static");
        softassert.assertAll("Results are not as expected when refreshed multiple times after static button click.");
    }


    /*
    8. Dynamic Controls

    Test clicks on the Remove Button and uses explicit wait.
    Test asserts that the checkbox is gone.
    Test clicks on Add Button and uses explicit wait.
    Test asserts that the checkbox is present.
    Test clicks on the Enable Button and uses explicit wait.
    Test asserts that the text box is enabled.
    Test clicks on the Disable Button and uses explicit wait.
    Test asserts that the text box is disabled. */

    @Test(priority = 8)
    public void DynamicControlsFunctionality (){
        LoadUrl("dynamic_controls");
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicControlsPage._removeButton);

        // Test clicks on the Remove Button and uses explicit wait. Test asserts that the checkbox is gone.
        dynamicControlsPage.ClickRemoveBtn();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicControlsPage._addButton);
        Assert.assertTrue(dynamicControlsPage.IsAddDisplayed(),"Check box should not be displayed.");

        //Test clicks on Add Button and uses explicit wait.Test asserts that the checkbox is present.
        dynamicControlsPage.ClickAddBtn();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicControlsPage._removeButton);
        Assert.assertTrue(dynamicControlsPage.IsCheckBoxDisplayed(),"Check box should be displayed.");

        //Test clicks on the Enable Button and uses explicit wait. Test asserts that the text box is enabled.
        dynamicControlsPage.ClickEnableBtn();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicControlsPage._disableButton);
        Assert.assertTrue(dynamicControlsPage._message.getText().trim().contains("enabled"),"Textbox is not enabled.");

        //Test clicks on the Disable Button and uses explicit wait. Test asserts that the text box is Disable.
        dynamicControlsPage.ClickDisableBtn();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicControlsPage._enableButton);
        Assert.assertTrue(dynamicControlsPage._message.getText().trim().contains("disabled"),"Textbox is not disabled.");
    }

    /*
    9. Dynamic Loading
    Test clicks the start button and uses explicit wait.
    Test asserts that “Hello World!” text is displayed. */

    @Test(priority = 9)
    public void DynamicLoading(){
        LoadUrl("dynamic_loading/2");
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicLoadingPage._startButton);

        dynamicLoadingPage.ClickStartBtn();
        SeleniumCommonMethods.WaitUntilElementAppears(dynamicLoadingPage._helloWorldText);
        Assert.assertTrue(dynamicLoadingPage.IsHelloWorldDisplayed(),"Hello world text is missing.");
    }

    /*
    10. File Download
    Test clicks on the file.
    Test asserts that the file is downloaded. */

    @Test(priority = 10)
    public void FileDownload() throws InterruptedException {
        LoadUrl("download");
        SeleniumCommonMethods.WaitUntilElementAppears(fileDownloadPage._fileDownload);

        fileDownloadPage.ClickOnFileDownload();
        Assert.assertTrue(fileDownloadPage.IsFileDownloadedInPath(),"File is not downloaded in the given path.");
    }

    /*
    11. File Upload
    Test uses Upload Button or Drag and Drop to upload a file.
    Test asserts that the file is uploaded.
    */

    @Test(priority = 11)
    public void FileUpload(){
        LoadUrl("upload");
        SeleniumCommonMethods.WaitUntilElementAppears(fileUploadPage._chooseFile);

        fileUploadPage.ChooseAndUploadFile();

        //  Test asserts that the file is uploaded.
        Assert.assertTrue(fileUploadPage.IsFileUploaded(),"File is not uploaded successfully.");
    }

    /*
    12.Floating Menu
    Test scrolls the page.
    Test asserts that the floating menu is still displayed.
     */
    @Test(priority = 12)
    public void FloatingMenu(){
        LoadUrl("floating_menu");
        SeleniumCommonMethods.WaitUntilElementAppears(floatingMenuPage._floatingMenuLocator);

        //Test scrolls the page and see if still the floating menu is displayed
        floatingMenuPage.GoToPageEnd();
        Assert.assertTrue(floatingMenuPage._floatingMenuLocator.isDisplayed(),"Floating menu bar is not displayed on scrolling down.");
    }

    /*
    13.Iframe
    Test switches to Iframe and types some text.
    Test asserts that the typed text is as expected.
     */
    @Test(priority = 13)
    public void Iframe(){
        LoadUrl("iframe");
        SeleniumCommonMethods.WaitUntilElementAppears(iframePage._iFrameLocator);

        //Test switches to Iframe and types some text.
        iframePage.SwitchToiFrame();
        //Test asserts that the typed text is as expected.
        iframePage.EnterText(iframePage.text);
        Assert.assertTrue(iframePage._contentBoxLocator.getText().trim().equalsIgnoreCase(iframePage.text),
                "Typed text is not as expected");
    }

    /*
    14.Mouse Hover
    Test does a mouse hover on each image.
    Test asserts that additional information is displayed for each image.
     */
    @Test(priority = 14)
    public void MouseHover(){
        LoadUrl("hovers");
        SeleniumCommonMethods.WaitUntilElementAppears(mouseHoverPage._firstImageLocator);

        //Mouse hover on first image
        mouseHoverPage.MouseHoverOnFirstImage(mouseHoverPage._firstImageLocator);
        Assert.assertTrue(mouseHoverPage.IsViewProfileOptionDisplayed(),"View profile is not displayed on mouse hover.");
        mouseHoverPage.ClickOnViewProfile();
        SeleniumCommonMethods.WaitUntilElementAppears(mouseHoverPage._profileNavigation);
        Assert.assertTrue(mouseHoverPage.IsProfileNavigated(),"Page is not navigated as expected.");
        mouseHoverPage.BrowserBack();
        mouseHoverPage.WaitMechanism();

        //mouse hover on second image
        mouseHoverPage.MouseHoverOnSecondImage(mouseHoverPage._firstImageLocator);
        Assert.assertTrue(mouseHoverPage.IsViewProfileOptionDisplayed(),"View profile is not displayed on mouse hover.");
        mouseHoverPage.ClickOnViewProfile();
        SeleniumCommonMethods.WaitUntilElementAppears(mouseHoverPage._profileNavigation);
        Assert.assertTrue(mouseHoverPage.IsProfileNavigated(),"Page is not navigated as expected.");
        mouseHoverPage.BrowserBack();
        mouseHoverPage.WaitMechanism();

        //mouse hover on third image
        mouseHoverPage.MouseHoverOnThirdImage(mouseHoverPage._firstImageLocator);
        Assert.assertTrue(mouseHoverPage.IsViewProfileOptionDisplayed(),"View profile is not displayed on mouse hover.");
        mouseHoverPage.ClickOnViewProfile();
        SeleniumCommonMethods.WaitUntilElementAppears(mouseHoverPage._profileNavigation);
        Assert.assertTrue(mouseHoverPage.IsProfileNavigated(),"Page is not navigated as expected.");
        mouseHoverPage.BrowserBack();
        mouseHoverPage.WaitMechanism();
    }

    /*
    15.JavaScript Alerts
    Test Clicks on JS Alert Button.
    Test asserts alert message.
    Test clicks on JS confirm Button and clicks ok on alert.
    Test asserts the alert message.
    Test clicks on JS Prompt Button and types a message on Prompt.
    Test asserts that the alert message contains the typed message.
     */
    @Test(priority = 15)
    public void JavaScriptAlerts(){
        LoadUrl("javascript_alerts");
        SeleniumCommonMethods.WaitUntilElementAppears(javaScriptAlertsPage._javaScriptAlertbtn);

        /* Test Clicks on JS Alert Button.Test asserts alert message.*/

        javaScriptAlertsPage.ClickJSAlertBtn_And_AcceptAlert();
        softassert.assertTrue(javaScriptAlertsPage.VerifyJSAlertIsClickedSuccessfully_Msg(),"");

       // Test clicks on JS confirm Button and clicks ok on alert. Test asserts the alert message.

        javaScriptAlertsPage.ClickJSConfirmBtn_And_ClickOK();
        softassert.assertTrue(javaScriptAlertsPage.VerifyOKBtnIsClicked_Msg(),"");

        javaScriptAlertsPage.ClickJSConfirmBtn_And_ClickCancel();
        softassert.assertTrue(javaScriptAlertsPage.VerifyCancelBtnIsClicked_Msg(),"");

        //  Test clicks on JS Prompt Button and types a message on Prompt. Test asserts that the alert message contains the typed message.

        javaScriptAlertsPage.ClickJSPromptBtn_And_Type_And_ClickOK("JavascriptAlertTest");
        softassert.assertTrue(javaScriptAlertsPage.VerifyPromptValue_Msg_OnClickingOK(),"");

        javaScriptAlertsPage.ClickJSPromptBtn_And_ClickCancel();
        softassert.assertTrue(javaScriptAlertsPage.VerifyPromptValue_Msg_OnClickingCancel(),"");
    }

    /*
    16. JavaScript Error
    Test finds the JavaScript error on the page.
    Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
     */
    @Test(priority = 16)
    public void JavaScriptError(){
        LoadUrl("javascript_error");
        SeleniumCommonMethods.WaitUntilElementAppears(javaScriptErrorPage._jsErrorLocator);

        //Test finds the JavaScript error on the page.
        Assert.assertTrue(javaScriptErrorPage.IsJavascriptErrorDisplayed(),"Error message should be displayed");
      //  Assert.assertEquals(javaScriptErrorPage.GetErrorMsg().equalsIgnoreCase(javaScriptErrorPage._jsErrorLocator.getText().trim()),
            //    "Error message is not as expected.");
    }

    /*
    17.Open in New Tab
    Test clicks on the Click Here link.

     */
    @Test(priority = 17)
    public void OpeninNewTab(){
        LoadUrl("windows");
        SeleniumCommonMethods.WaitUntilElementAppears(openNewTabPage._clickHereBtn);

        // Test clicks on the Click Here link.
        openNewTabPage.ClickOnClickHerBtn();

        // Test asserts that a new tab is opened with text New Window.
        openNewTabPage.SwitchTabs(1);
        Assert.assertTrue(openNewTabPage.IsNewTabOpened(),"New tab should be opened.");
        SeleniumCommonMethods.SwitchBackTab();
    }

    /*
    18.Notification Message
    Test clicks on the Click Here link a multiple times.
    Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.*/
    @Test(priority = 18)
    public void NotificationMessage(){
        LoadUrl("notification_message_rendered");
        notificationMessagePage.ClickForNotificationMsg();
        Assert.assertTrue(notificationMessagePage.IsNotificationMsgDisplayed(),"Notification message is not displayed.");
        //Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
        Assert.assertTrue(notificationMessagePage._notificationMsgText.getText().contains("Action"),"Message is not as expected.");
        notificationMessagePage.ClickForNotificationMsg();
        Assert.assertTrue(notificationMessagePage._notificationMsgText.getText().contains("Action"),"Message is not as expected.");
    }
}
