package com.testbase;

import com.pages.*;
import org.testng.annotations.BeforeClass;

public class PageInitialisation extends ValueRepository{

    // Page Initialisation

    public static LoginPage loginpage;
    public static CheckboxPage checkboxpage;
    public static ContextClick contextClick;
    public static DragAndDropPage dragAndDropPage;
    public static DropdownPage dropdownPage;
    public static DynamicContentPage dynamicContentPage;
    public static DynamicControlsPage dynamicControlsPage;
    public static DynamicLoadingPage dynamicLoadingPage;
    public static FileDownloadPage fileDownloadPage;
    public static FileUploadPage fileUploadPage;
    public static FloatingMenuPage floatingMenuPage;
    public static IFramePage iFramePage;
    public static MouseHoverPage mouseHoverPage;
    public static JavaScriptAlertsPage javaScriptAlertsPage;
    public static JavaScriptErrorPage javaScriptErrorPage;
    public static NewTabPage newTabPage;
    public static NotificationMessagePage notificationMessagePage;

@BeforeClass
    public void methodInitialize(){
        loginpage = new LoginPage(driver);
        checkboxpage = new CheckboxPage(driver);
        contextClick = new ContextClick(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        dropdownPage = new DropdownPage(driver);
        dynamicContentPage = new DynamicContentPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        fileDownloadPage = new FileDownloadPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        floatingMenuPage = new FloatingMenuPage(driver);
        iFramePage = new IFramePage(driver);
        mouseHoverPage = new MouseHoverPage(driver);
        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptErrorPage = new JavaScriptErrorPage(driver);
        newTabPage = new NewTabPage(driver);
        notificationMessagePage = new NotificationMessagePage(driver);
    }
}