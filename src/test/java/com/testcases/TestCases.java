package com.testcases;

import com.pages.LoginPage;
import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class TestCases extends BaseClass {


   // private String FileDownloadValidation;

    @Test(enabled = true, priority = 1)
    //Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    public void VerifySuccesfulLogin(){
          //Navigate to Module
          ModuleNavigation("login");
          loginpage.WaitTillvisiblityofLoginButton();
          //Type credentials and to Login
          loginpage.TypeUserName(_userName_Correct);
          loginpage.TypePassword(_password_Correct);
          loginpage.ClickLoginButton();

          // wait till login button is visible on the next page
          loginpage.WaitTillVisibityofLogoutButton();
          assertTrue(loginpage.SecureAreaNavigation(),"Not Navigated to Secure Area or 'Welcome to the Secure Area. When you are done click logout below.- Mesage is missing'");
          loginpage.ClickLogoutButton();
    }

    @Test(enabled = true, priority = 2)
    //Login Failure: http://localhost:7080/login Login fail invalid creadentials
    public void VerifyUsernameIsInvalid(){

        //Navigate to login Module
        ModuleNavigation("login");
        loginpage.WaitTillvisiblityofLoginButton();

        //Login using invalid credentials
        loginpage.TypeUserName(_userName_Wrong);
        loginpage.TypePassword(_password_Correct);
        loginpage.ClickLoginButton();

        //Verify invalid Username Message
        assertTrue(loginpage.VerifyinvalidusernameMessage(),"Your username is invalid!- message is missing");

    }

    @Test(enabled = true, priority = 3)
    //Login Failure: http://localhost:7080/login Login fail invalid creadentials
    public void VerifyPasswordIsInvalid(){
        //Navigate to login Module
        ModuleNavigation("login");
        loginpage.WaitTillvisiblityofLoginButton();

        //Login using invalid credentials
        loginpage.TypeUserName(_userName_Correct);
        loginpage.TypePassword(_password_Wrong);
        loginpage.ClickLoginButton();

        //Verify invalid Username Message
        assertTrue(loginpage.VerifyinvalidPasswordMessage(),"Your password is invalid!- message is missing ");
    }

    @Test(enabled = true, priority = 4)
    // CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    public void Checkboxverification(){
        //Navigate to checkbox Module
        ModuleNavigation("checkboxes");
        checkboxpage.WaitTillvisiblityofCheckbox();
        // click on Checkbox 1
        checkboxpage.ClickCheckbox1();
        assertTrue(checkboxpage._checkBox1.isSelected(),"Checkbox 1 is Checked ");
        // click on Checkbox 2
        checkboxpage.ClickCheckbox2();
        assertFalse(checkboxpage._checkBox2.isSelected(),"Checkbox 2 is unchecked ");
    }

    @Test(enabled = true, priority = 5)
    //ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
    public void ContextClickandPopUp(){
        //Navigate to context_menu Module
        ModuleNavigation("context_menu");
        CommonMethods.WaitTillElementIsVisible(contextClick._rightClickBox);

        //Context click
        contextClick.RightclickOnBox();

        //alert Verification
        assertTrue(CommonMethods.GetAlertText().equalsIgnoreCase("You selected a context menu"),"You selected a context menu Message is missing on th popup");

        //Accept alert
        CommonMethods.AlertAccept();
    }

    @Test(enabled = true, priority = 6)
    //Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    public void DragAndDropValidation() throws InterruptedException {
        //Navigate to drag_and_drop module
        ModuleNavigation("drag_and_drop");
        CommonMethods.WaitTillElementIsVisible(dragAndDropPage._dragElement);
        CommonMethods.Wait_ajax();
        //storing the drag and drop box text values
        String DragElementText  = dragAndDropPage.GetDragElementText();
        String DropElementText  = dragAndDropPage.GetDropElementText();
        // performing drag and drop action
        dragAndDropPage._dragElement.click();
        CommonMethods.DragAndDrop(dragAndDropPage._dragElement,dragAndDropPage._dropElement);

        // Post verification after drag and drop
        //Drag element will be the drop element i.e A Will become B
        assertTrue(DragElementText.equalsIgnoreCase(dragAndDropPage.GetDropElementText()), "Drag and Drop not Successful" );

        //Drag element will be the drop element i.e B Will become A
        assertTrue(DropElementText.equalsIgnoreCase(dragAndDropPage.GetDragElementText()), "Drag and Drop not Successful" );

    }

    @Test(enabled = true, priority = 7)
    //Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    public void DropdownValidation() {
        //Navigate to dropdown Module
        ModuleNavigation("dropdown");
        CommonMethods.WaitTillElementIsVisible(dropdownPage._dropdownBoxID);

        //Select A value from drom dropdown via visible text
        CommonMethods.SelectDropDownByText(dropdownPage._dropdownBoxID, "Option 1");
        //Verify the selected option
        assertTrue(CommonMethods.GetSelectedDropdownValue(dropdownPage._dropdownBoxID).equalsIgnoreCase("Option 1"), "Selected value is not option 1 ");

        //Select Another value from drop dropdown via value
        CommonMethods.SelectDropDownByValue(dropdownPage._dropdownBoxID,"2");
        assertTrue(CommonMethods.GetSelectedDropdownValue(dropdownPage._dropdownBoxID).equalsIgnoreCase("Option 2"), "Selected value is not option 2 ");

    }

    @Test(enabled = true, priority = 8)
    //Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
    public void DynamicContentValidation() throws InterruptedException {
        //Navigate to dynamic_content Module
        ModuleNavigation("dynamic_content");
        CommonMethods.WaitTillElementIsClickable(dynamicContentPage._clickHereButton);

        //Store all the dynamic texts
        dynamicContentPage.StoreDynamicText();
       //Refresh the page
        CommonMethods.BrowserPageRefresh();
        //Compare the old value with new value - if dynamic strings will never be equal
        softAssert.assertFalse(dynamicContentPage._dynamicContent1text.equalsIgnoreCase(dynamicContentPage._dynamicContent1.getText().trim()),"Dynamic content 1 has not changed ");
        softAssert.assertFalse(dynamicContentPage._dynamicContent2text.equalsIgnoreCase(dynamicContentPage._dynamicContent2.getText().trim()),"Dynamic content 2 has not changed ");
        softAssert.assertFalse(dynamicContentPage._dynamicContent2text.equalsIgnoreCase(dynamicContentPage._dynamicContent3.getText().trim()),"Dynamic content 3 has not changed ");
        //Refresh the page- again
        CommonMethods.BrowserPageRefresh();

        //Clicking the static field button
        dynamicContentPage.ClickClickHereButton();

        //wait till the Pageloads
        CommonMethods.Wait_ajax();

        //Store all the dynamic texts
        dynamicContentPage.StoreDynamicText();

        //Clicking the static field button
        dynamicContentPage.ClickClickHereButton();

        //compare the contents ; this time 1 and 2 will be eual and the third one changes
        softAssert.assertTrue(dynamicContentPage._dynamicContent1text.equalsIgnoreCase(dynamicContentPage._dynamicContent1.getText().trim()),"Dynamic content 1 Value Mismatch ");
        softAssert.assertTrue(dynamicContentPage._dynamicContent2text.equalsIgnoreCase(dynamicContentPage._dynamicContent2.getText().trim()),"Dynamic content 2 Value Mismatch ");
        softAssert.assertFalse(dynamicContentPage._dynamicContent2text.equalsIgnoreCase(dynamicContentPage._dynamicContent3.getText().trim()),"Dynamic content 3 has not changed ");

        softAssert.assertAll();

    }

    @Test(enabled = true, priority = 9)
    //Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
    public void DynamicControlsValidation(){
        //Navigate to dynamic_controls Module
        ModuleNavigation("dynamic_controls");
        //THis explicit wait will wait till the remove button becomes clickable
        CommonMethods.WaitTillElementIsClickable(dynamicControlsPage._removeButton);

        //Clicks Remove button
        dynamicControlsPage.ClickRemoveButton();
        // This explicit will wait till the invisibility of the Checkbox
        CommonMethods.WaitTillElementIsVisible(dynamicControlsPage._addButton);
        assertTrue(dynamicControlsPage._addButton.isDisplayed(),"Add button is missing");

        //Click on Add button
        dynamicControlsPage.ClickAddButton();

        //This explicit wait will wait till the vibility of check box
        CommonMethods.WaitTillElementIsVisible(dynamicControlsPage._checkbox);
        assertTrue(dynamicControlsPage._removeButton.isDisplayed(),"Add button is Still there");

        //Clicks on the enable button
        dynamicControlsPage.ClickEnableButton();
        //waits for the button to go invisible
        CommonMethods.WaitTillElementIsVisible(dynamicControlsPage._disableButton);
        //Verify wether the textbox is enabled or not
        assertTrue(dynamicControlsPage._textBox.isEnabled(),"Textbox is not enabled");
       //types text to the field after enabling
        dynamicControlsPage._textBox.sendKeys("Test");

        //Click on the disable button
        dynamicControlsPage.ClickDisableButton();
        //wait till the vibility of the enable button
        CommonMethods.WaitTillElementIsVisible(dynamicControlsPage._enableButton);
        //Verify wether the textbox is diabled or not

        assertTrue(dynamicControlsPage._enableButton.isDisplayed(),"Textbox is not enabled");


    }

    @Test(enabled = true, priority = 10)
    //Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
    public void DynamicLoadingValidation(){
        //Navigate to dynamic_loading/2 Module
        ModuleNavigation("dynamic_loading/2");
        CommonMethods.WaitTillElementIsVisible(dynamicLoadingPage._startButton);

        //Click Start button
        dynamicLoadingPage.ClickStartButton();
        //wait till the message displays
        CommonMethods.WaitTillElementIsVisible(dynamicLoadingPage._message);

        Assert.assertTrue(dynamicLoadingPage._message.getText().trim().equalsIgnoreCase(dynamicLoadingPage._expectedMessage),"Expected message is not matching with the displayed message ");


    }

    @Test(enabled = true, priority = 11)
    //File Download: http://localhost:7080/download Test File Download.
    public void FileDownloadValidation() throws InterruptedException {
        //Navigate to download Module
        ModuleNavigation("download");
        CommonMethods.WaitTillElementIsVisible(fileDownloadPage._fileDownloadButton);

        //Click on the file link
        fileDownloadPage.ClickOnFile();
        CommonMethods.Wait_ajax();
        //This will verify the presence of the file on the specific location
        Assert.assertTrue(CommonMethods.VerifyDownloadedFile(DownloadPath,"some-file.txt"));


    }

   // @Test(enabled = true, priority = 12, dependsOnMethods = {"FileDownloadValidation"})
    @Test(enabled = true, priority = 12)
    //File Upload: http://localhost:7080/upload Test File Upload.
    public void FileUploadValidation() throws InterruptedException {
        //Navigate to upload Module
        ModuleNavigation("upload");
        CommonMethods.WaitTillElementIsClickable(fileUploadPage._uploadButton);

        //Uploadfile from the folder
        fileUploadPage.FileUpload();

        fileUploadPage.ClickUploadButton();


        //Verify Uploaded Files

        Assert.assertTrue(fileUploadPage._uploadedFileName.getText().trim().equalsIgnoreCase("some-file.txt"),"Filename Mismatch");


    }

    @Test(enabled = true, priority = 13)
    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    public void FloatingMenuValidation(){
        //Navigate to floating_menu Module
        ModuleNavigation("floating_menu");
        CommonMethods.WaitTillElementIsVisible(floatingMenuPage._aboutButton);

        //Scrolldown to verify the floating menu
        CommonMethods.PageScrollDown();

        //Verification of the floating menu
        Assert.assertTrue(floatingMenuPage._aboutButton.isDisplayed(),"About Button is missing");
        Assert.assertTrue(floatingMenuPage._contactButton.isDisplayed(),"Contact Button is missing");
        Assert.assertTrue(floatingMenuPage._homeButton.isDisplayed(),"Home Button is missing");
        Assert.assertTrue(floatingMenuPage._newsButton.isDisplayed(),"News Button is missing");



    }

    @Test(enabled = true, priority = 14)
    //Iframe: http://localhost:7080/iframe Test iframe.
    public void IFrameValidation() throws InterruptedException {
        //Navigate to iframe. Module
        ModuleNavigation("iframe");
        CommonMethods.Wait_ajax();

        //Switch the focus of the driver to iFrame
        iFramePage.SwitchtoiFrame();
        //Type inside the textbox
        iFramePage.TextBoxType("This is a sample Text inside Frame");

    }

    @Test(enabled = true, priority = 15)
    //Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    public void MouseHoverValidation() throws InterruptedException {
        //Navigate to hovers  Module
        ModuleNavigation("hovers");
        CommonMethods.WaitTillElementIsVisible(mouseHoverPage._user1Img);

        //Hover OverFirstImage and Click View Profile
        mouseHoverPage.HoverOverImage1ClickViewProfile();
        softAssert.assertTrue(mouseHoverPage.NextPageHeaderValidation(),"Hover over first image did not work ");
        CommonMethods.BrowserNavigateBack();
        CommonMethods.WaitTillElementIsVisible(mouseHoverPage._user1Img);

        //Hover Over Second Image and Click View Profile

        mouseHoverPage.HoverOverImage2ClickViewProfile();
        softAssert.assertTrue(mouseHoverPage.NextPageHeaderValidation(),"Hover over Second image did not work ");
        CommonMethods.BrowserNavigateBack();
        CommonMethods.WaitTillElementIsVisible(mouseHoverPage._user1Img);

        //Hover Over third Image and Click View Profile

        mouseHoverPage.HoverOverImage3ClickViewProfile();
        softAssert.assertTrue(mouseHoverPage.NextPageHeaderValidation(),"Hover over Third image did not work ");
        CommonMethods.BrowserNavigateBack();
        CommonMethods.WaitTillElementIsVisible(mouseHoverPage._user1Img);
        softAssert.assertAll();


    }

    @Test(enabled = true, priority = 16)
    //JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert
    public void JavaScriptAlertsValidation(){
        //Navigate to javascript_alerts Module
        ModuleNavigation("javascript_alerts");
        CommonMethods.WaitTillElementIsVisible(javaScriptAlertsPage._jSAlertbutton);

        //Click javascript Alert Button
        javaScriptAlertsPage.ClickJSAlertButton();
        CommonMethods.AlertAccept();
        softAssert.assertTrue(javaScriptAlertsPage.GetResultText().equalsIgnoreCase("You successfully clicked an alert"),"You successfuly clicked an alert - result message mismatch");

        //Click "OK" Javascript based Confirm button
        javaScriptAlertsPage.ClickJSConfirmButton();
        CommonMethods.AlertAccept();
        softAssert.assertTrue(javaScriptAlertsPage.GetResultText().equalsIgnoreCase("You clicked: Ok"),"You clicked: Ok - result message mismatch");

        //Click "Cancel" Javascript based Confirm button
        javaScriptAlertsPage.ClickJSConfirmButton();
        CommonMethods.AlertDismiss();
        softAssert.assertTrue(javaScriptAlertsPage.GetResultText().equalsIgnoreCase("You clicked: Cancel"),"You clicked: Cancel - result message mismatch");

        //Type prompt and click OK on JSPrompt
        javaScriptAlertsPage.ClickJSpromptButton();
        CommonMethods.TypeAlertText("JavaTest");
        softAssert.assertTrue(javaScriptAlertsPage.GetResultText().equalsIgnoreCase("You entered: JavaTest"),"You entered: JavaTest - result message mismatch");

        //Click cancel without typing on JS Prompt

        javaScriptAlertsPage.ClickJSpromptButton();
        CommonMethods.AlertDismiss();
        softAssert.assertTrue(javaScriptAlertsPage.GetResultText().equalsIgnoreCase("You entered: null"),"You entered: null - result message mismatch");

        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 17)
    //JavaScript Error: http://localhost:7080/javascript_error Test JS error
    public void JavaScriptErrorValidation(){
        //Navigate to javascript_error Module
        ModuleNavigation("javascript_error");
        CommonMethods.WaitTillElementIsVisible(javaScriptErrorPage._javascriptError);

        //Validate the Error Message of Java script
        assertTrue(javaScriptErrorPage.GetJavascriptErrorMessage().contains(javaScriptErrorPage._javascriptErrorMessage),"Javascript error Message mismatch");
    }

    @Test(enabled = true, priority = 18)
    //Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    public void NewTabValidation(){
        //Navigate to New Tab Module
        ModuleNavigation("windows");
        CommonMethods.WaitTillElementIsVisible(newTabPage._clickHereButton);

        //Click on click here button and turn the drivers focus to new tab
        newTabPage.ClickClickHereButton();
        assertTrue(newTabPage.NewWindowMessageValidation(),"New Window message is missing");

        //Switch back control to old tab
        CommonMethods.Switch_Old_Tab();
        assertTrue(newTabPage._clickHereButton.isDisplayed(),"Click here button is missing or control was not on old tab ");
    }

    @Test(enabled = true, priority = 19)
    //Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
    public void NotificationMessageValidation(){
        //Navigate to notification_message_rendered  Module
        ModuleNavigation("notification_message_rendered");
        CommonMethods.WaitTillElementIsVisible(notificationMessagePage._clickHereButton);

        //Verify notification
       // if(!notificationMessagePage.IsFlashAlertPresent()){

            // Click the click here Button
            notificationMessagePage.ClickClickHereButton();
            CommonMethods.WaitTillElementIsVisible(notificationMessagePage._flashMessage);

            //Soft Assert for verifying two or three conditions at the same time
            softAssert.assertTrue(notificationMessagePage.IsFlashAlertPresent(),"Flash Alert Is missing ");
            softAssert.assertTrue(notificationMessagePage.GetflashMessage().contains("Action"),"Alert message text doesnot Match");
            softAssert.assertAll();
       // }

    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        softAssert = new SoftAssert();

    }
}
