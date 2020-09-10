package base;

import pages.*;

public class PageInit extends MainClass {
    public static LoginPage login;
    public static SecureAreaPage secureArea;
    public static CheckboxesPage checkboxes;
    public static ContextMenuPage contextMenu;
    public static DragAndDropPage drugAndDrop;
    public static JavaScriptAlertsPage javaScriptAlertsPage;
    public static JavaScriptErrorPage javaScriptErrorPage;
    public static OpeninNewTabPage openinNewTabPage;
    public static NotificationMessagePage notificationMessagePage;
    public static MouseHoverPage mouseHoverPage;
    public static DropdownPage dropdownPage;
    public static DynamicContentPage dynamicContentPage;
    public static DynamicControlsPage dynamicControlsPage;
    public static DynamicLoadingPage dynamicLoadingPage;
    public static FileDownloadPage fileDownloadPage;
    public static FileUploadPage fileUploadPage;
    public static IFramePage iframePage;
    public static FloatingMenuPage floatingMenuPage;

    public static void initialize() {

        login = new LoginPage();
        secureArea = new SecureAreaPage();
        checkboxes = new CheckboxesPage();
        contextMenu = new ContextMenuPage();
        drugAndDrop = new DragAndDropPage();
        javaScriptAlertsPage = new JavaScriptAlertsPage();
        javaScriptErrorPage = new JavaScriptErrorPage();
        openinNewTabPage = new OpeninNewTabPage();
        notificationMessagePage = new NotificationMessagePage();
        mouseHoverPage = new MouseHoverPage();
        dropdownPage = new DropdownPage();
        dynamicContentPage = new DynamicContentPage();
        dynamicControlsPage = new DynamicControlsPage();
        dynamicLoadingPage = new DynamicLoadingPage();
        fileDownloadPage = new FileDownloadPage();
        fileUploadPage = new FileUploadPage();
        iframePage = new IFramePage();
        floatingMenuPage = new FloatingMenuPage();

    }
}
