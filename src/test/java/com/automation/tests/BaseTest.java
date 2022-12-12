package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverUtils;
import org.testng.annotations.*;

public class BaseTest {
    CheckBoxesPage checkBoxesPage;
    ContextMenuPage contextMenuPage;
    DragAndDropPage dragAndDropPage;
    DropDownPage dropDownPage;
    DynamicContentPage dynamicContentPage;
    DynamicLoadingPage dynamicLoadingPage;
    FileDownloadPage fileDownloadPage;
    FileUploadPage fileUploadPage;
    FloatingMenuPage floatingMenuPage;
    IframePage iframePage;
    MouseHoverPage mouseHoverPage;
    JavaScriptAlertsPage javaScriptAlertsPage;
    JavaScriptErrorPage javaScriptErrorPage;
    OpenNewTabPage openNewTabPage;
    NotificationMessagePage notificationMessagePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        ConfigReader.initProperties();
        DriverUtils.createDriver();
        checkBoxesPage = new CheckBoxesPage();
        contextMenuPage = new ContextMenuPage();
        dragAndDropPage = new DragAndDropPage();
        dropDownPage = new DropDownPage();
        dynamicContentPage= new DynamicContentPage();
        dynamicLoadingPage = new DynamicLoadingPage();
        fileDownloadPage = new FileDownloadPage();
        fileUploadPage = new FileUploadPage();
        floatingMenuPage = new FloatingMenuPage();
        iframePage = new IframePage();
        mouseHoverPage = new MouseHoverPage();
        javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptErrorPage = new JavaScriptErrorPage();
        openNewTabPage = new OpenNewTabPage();
        notificationMessagePage = new NotificationMessagePage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown(){
        DriverUtils.getDriver().quit();
    }
}
