package com.dotdash.utils;

import com.dotdash.pages.*;

public class PageInitializers {
    public static CheckBoxesPage checkBoxesPage;
    public static ContextMenuPage contextMenuPage;
    public static DragDropPage dragDropPage;
    public static DropDownPage dropDownPage;
    public static DynamicContentPage dynamicContentPage;
    public static DynamicControlsPage dynamicControlsPage;
    public static FileDownLoadAndUploadPage fileDownLoadAndUploadPage;
    public static FloatingMenuPage floatingMenuPage;
    public static JSPage jsPage;
    public static LoginPage loginPage;
    public static MouseHoverPage mouseHoverPage;
    public static NotificationPage notificationPage;
    public static SwitchToFrameAndWindowPage switchToFrameAndWindowPage;

    public static void initializePageObjects() {
        checkBoxesPage = new CheckBoxesPage();
        contextMenuPage = new ContextMenuPage();
        dragDropPage = new DragDropPage();
        dropDownPage = new DropDownPage();
        dynamicContentPage = new DynamicContentPage();
        dynamicControlsPage = new DynamicControlsPage();
        fileDownLoadAndUploadPage = new FileDownLoadAndUploadPage();
        floatingMenuPage = new FloatingMenuPage();
        jsPage = new JSPage();
        loginPage = new LoginPage();
        mouseHoverPage = new MouseHoverPage();
        notificationPage = new NotificationPage();
        switchToFrameAndWindowPage = new SwitchToFrameAndWindowPage();
    }
}
