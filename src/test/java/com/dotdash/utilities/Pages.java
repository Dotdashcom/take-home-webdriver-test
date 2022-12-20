package com.dotdash.utilities;

import com.dotdash.pages.*;


public class Pages {
    private LoginPage loginPage;
    private Securepage securepage;
    private CheckboxPage checkboxPage;
    private ContextMenuPage contextMenuPage;
    private DragAndDropPage dragAndDropPage;
    private DropdownPage dropdownPage;
    private DynamicContentPage dynamicContentPage;
    private DynamicControlsPage dynamicControlsPage;
    private DynamicLoadingPage dynamicLoadingPage;
    private FileDownloadPage fileDownloadPage;
    private FileUploadPage fileUploadPage;
    private FloatingMenuPage floatingMenuPage;
    private IframePage iframePage;
    private JavaScriptAlertsPage javaScriptAlertsPage;
    private JavaScriptErrorPage javaScriptErrorPage;
    private MouseHoverPage mouseHoverPage;
    private NotificationMessagePage notificationMessagePage;
    private OpenNewTabPage openNewTabPage;


    public Pages() {
        this.loginPage = new LoginPage();
        this.securepage = new Securepage();
        this.checkboxPage = new CheckboxPage();
        this.contextMenuPage = new ContextMenuPage();
        this.dragAndDropPage = new DragAndDropPage();
        this.dropdownPage = new DropdownPage();
        this.dynamicContentPage = new DynamicContentPage();
        this.dynamicControlsPage = new DynamicControlsPage();
        this.dynamicLoadingPage = new DynamicLoadingPage();
        this.fileUploadPage = new FileUploadPage();
        this.fileDownloadPage = new FileDownloadPage();
        this.floatingMenuPage = new FloatingMenuPage();
        this.iframePage = new IframePage();
        this.javaScriptAlertsPage = new JavaScriptAlertsPage();
        this.javaScriptErrorPage = new JavaScriptErrorPage();
        this.mouseHoverPage = new MouseHoverPage();
        this.notificationMessagePage = new NotificationMessagePage();
        this.openNewTabPage = new OpenNewTabPage();
    }

    public LoginPage loginPage() {
        return loginPage;
    }
    public Securepage securepage() {return securepage; }
    public CheckboxPage checkboxPage() {return checkboxPage; }
    public ContextMenuPage contextMenuPage (){ return contextMenuPage;}
    public DragAndDropPage dragAndDropPage (){ return dragAndDropPage;}
    public DropdownPage dropdownPage (){ return dropdownPage;}
    public DynamicContentPage dynamicContentPage (){ return dynamicContentPage;}
    public DynamicControlsPage dynamicControlsPage () { return dynamicControlsPage;}
    public DynamicLoadingPage dynamicLoadingPage () { return dynamicLoadingPage;}
    public FileUploadPage fileUploadPage () { return  fileUploadPage;}
    public FileDownloadPage fileDownloadPage() { return  fileDownloadPage;}
    public FloatingMenuPage floatingMenuPage() { return  floatingMenuPage;}
    public IframePage iframePage() { return iframePage;}
    public JavaScriptErrorPage javaScriptErrorPage () { return javaScriptErrorPage;}
    public JavaScriptAlertsPage javaScriptAlertsPage() { return javaScriptAlertsPage;}
    public MouseHoverPage mouseHoverPage() { return mouseHoverPage;}
    public NotificationMessagePage notificationMessagePage() { return notificationMessagePage;}
    public OpenNewTabPage openNewTabPage() { return openNewTabPage;}
    }
