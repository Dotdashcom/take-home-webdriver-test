package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class DDMAssessmentTest extends DDMBasePageTest  {
    protected DDMLoginPage loginPage;
    protected DDMCheckBoxPage checkBoxPage;
    protected DDMContextMenuPage contextMenuPage;
    protected DDMDropDownPage dropDownPage;
    protected DDMDynamicContentPage dynamicContentPage;
    protected DDMDynamicControlsPage dynamicControlsPage;
    protected DDMDynamicLoadingPage dynamicLoadingPage;
    protected DDMFileDownloadPage fileDownloadPage;
    protected DDMFileUploadPage fileUploadPage;
    protected DDMFloatingMenuPage floatingMenuPage;
    protected DDMIframePage iframePage;
    protected DDMMouseHoverPage mouseHoverPage;
    protected DDMJavaScriptAlertPage javaScriptAlertPage;
    protected DDMJavaScriptErrorPage javaScriptErrorPage;

    @Test(priority = 0)
    public void loginSuccessTest()  {
        loginPage = landingPage.getPageObject(DDMLoginPage.class);
        loginPage.performLogin(validUserName, validPassword);
        Assert.assertTrue(loginPage.getLoginResultMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 1)
    public void loginFailureTest()  {
        loginPage = landingPage.getPageObject(DDMLoginPage.class);
        SoftAssert softAssert = new SoftAssert();
        loginPage.performLogin("WrongUserName", validPassword);
        softAssert.assertTrue(loginPage.getLoginResultMessage().contains("Your username is invalid!"));

        loginPage.performLogin(validUserName, "WrongPassWord");
        softAssert.assertTrue(loginPage.getLoginResultMessage().contains( "Your password is invalid!"));
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void selectCheckBoxTest()  {
        checkBoxPage = landingPage.getPageObject(DDMCheckBoxPage.class);
        checkBoxPage.selectCheckBox(0);
        Assert.assertTrue(checkBoxPage.isCheckBoxSelected(0));
    }

    @Test(priority = 3)
    public void unselectedCheckBoxTest()  {
        checkBoxPage = landingPage.getPageObject(DDMCheckBoxPage.class);
        checkBoxPage.selectCheckBox(1);
        Assert.assertFalse(checkBoxPage.isCheckBoxSelected(1));
    }

    @Test(priority = 4)
    public void contextMenuTest()  {
        contextMenuPage = landingPage.getPageObject(DDMContextMenuPage.class);
        contextMenuPage.rightClick();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }

    @Test(priority = 6)
    public void dropDownTest()  {
        dropDownPage = landingPage.getPageObject(DDMDropDownPage.class);
        dropDownPage.selectOption("Option 1");
        Assert.assertEquals(dropDownPage.getSelectedOption(), "Option 1");
        dropDownPage.selectOption("Option 2");
        Assert.assertEquals(dropDownPage.getSelectedOption(), "Option 2");
    }

    @Test(priority = 7)
    public void dynamicContentTest()  {
        dynamicContentPage = landingPage.getPageObject(DDMDynamicContentPage.class);
        String textBeforeRefresh = dynamicContentPage.getParagraphContent(0);
        dynamicContentPage.refreshPage();
        String textAfterRefresh = dynamicContentPage.getParagraphContent(0);
        Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
    }

    @Test(priority = 8)
    public void dynamicControlTest()  {
        dynamicControlsPage = landingPage.getPageObject(DDMDynamicControlsPage.class);
        SoftAssert softAssert = new SoftAssert();
        dynamicControlsPage.removeCheckBox();
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's gone!");

        softAssert.assertTrue(dynamicControlsPage.addCheckBox());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's back!");

        softAssert.assertTrue(dynamicControlsPage.enableButtonClick());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's enabled!");

        softAssert.assertFalse(dynamicControlsPage.disableButtonClick());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's disabled!");
    }

    @Test(priority = 9)
    public void dynamicLoadingTest()  {
        dynamicLoadingPage = landingPage.getPageObject(DDMDynamicLoadingPage.class);
        dynamicLoadingPage.startDynamicLoading();
        Assert.assertEquals(dynamicLoadingPage.getLoadingTextMessage(), "Hello World!");
    }

    @Test(priority = 10)
    public void fileDownloadTest()  {
        fileDownloadPage = landingPage.getPageObject(DDMFileDownloadPage.class);
        fileDownloadPage.downloadFile();
        Assert.assertTrue(fileDownloadPage.isFileDownloaded());
    }

    @Test(priority = 11)
    public void fileUploadTest()  {
        fileUploadPage = landingPage.getPageObject(DDMFileUploadPage.class);
        fileUploadPage.uploadFile();
        Assert.assertTrue(fileUploadPage.uploadedFileName().contains("automation.jpg"));
    }

    @Test(priority = 12)
    public void floatingMenuTest()  {
        floatingMenuPage = landingPage.getPageObject(DDMFloatingMenuPage.class);
        floatingMenuPage.scrollByOnePage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }

    @Test(priority = 13)
    public void iFrameTest()  {
        iframePage = landingPage.getPageObject(DDMIframePage.class);
        iframePage.typeInsideIFrame();
        Assert.assertEquals(iframePage.getIframeText(), "Hello there.");
    }

    @Test(priority = 14)
    public void mouseHoverTest()  {
        mouseHoverPage = landingPage.getPageObject(DDMMouseHoverPage.class);
        mouseHoverPage.mouseHoverProfile(0);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(0));
        mouseHoverPage.mouseHoverProfile(1);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(1));
        mouseHoverPage.mouseHoverProfile(2);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(2));
    }

    @Test(priority = 15)
    public void javaScriptAlertTest()  {
        javaScriptAlertPage = landingPage.getPageObject(DDMJavaScriptAlertPage.class);
        javaScriptAlertPage.clickOnAlert();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(), "You successfuly clicked an alert");
        javaScriptAlertPage.clickJSconfirm();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(), "You clicked: Ok");
        javaScriptAlertPage.clickJSprompt();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(),"You entered: Hello there.");
    }

    @Test(priority = 16)
    public void javaScriptErrorTest()  {
        javaScriptErrorPage = landingPage.getPageObject(DDMJavaScriptErrorPage.class);
        Assert.assertTrue(javaScriptErrorPage.javaScriptErrorMessage());
    }
}