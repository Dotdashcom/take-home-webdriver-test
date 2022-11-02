package com.takehomewebdrivertest;

import static com.takehomewebdrivertest.Hooks.driver;


public class BaseTest {

    protected LoginPage loginPage = new LoginPage(driver);
    protected SecurePage securePage = new SecurePage(driver);
    protected CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
    protected ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
    protected DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
    protected DropdownPage dropdownPage = new DropdownPage(driver);
    protected DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
    protected DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
    protected DownloadPage downloadPage = new DownloadPage(driver);
    protected FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
    protected IFramePage iFramePage = new IFramePage(driver);
    protected JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    protected WindowsPage windowsPage = new WindowsPage(driver);
    protected NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
    protected HoverMousePage hoverMousePage = new HoverMousePage(driver);

}
