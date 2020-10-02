package com.Repository;

import com.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class PageInvocation {
    public static String windowHandle;
    public static WebDriver driver;
    public SoftAssert softassert;

    public static LoginRepository logInPage;
    public static CheckBoxRepository checkBoxPage;
    public static ContextMenuRepository contextMenuPage;
    public static DragAndDropRepository dragAndDropPage;
    public static DropDownRepository dropDownPage;
    public static DynamicContentRepository dynamicContentPage;
    public static DynamicControlsRepository dynamicControlsPage;
    public static DynamicLoadingRepository dynamicLoadingPage;
    public static FileDownloadRepository fileDownloadPage;
    public static FileUploadRepository fileUploadPage;
    public static FloatingMenuRepository floatingMenuPage;
    public static iFrameRepository iframePage;
    public static MouseHoverRepository mouseHoverPage;
    public static JavaScriptAlertsRepository javaScriptAlertsPage;
    public static JavaScriptErrorRepository javaScriptErrorPage;
    public static OpenNewTabRepository openNewTabPage;
    public static NotificationMessageRepository notificationMessagePage;



    //page object initialisation
    @BeforeClass
    public void PageObjectInitialisation(){
        logInPage = new LoginRepository(driver);
        checkBoxPage=new CheckBoxRepository(driver);
        contextMenuPage=new ContextMenuRepository(driver);
        dragAndDropPage = new DragAndDropRepository(driver);
        dropDownPage = new DropDownRepository(driver);
        dynamicContentPage = new DynamicContentRepository(driver);
        dynamicControlsPage = new DynamicControlsRepository(driver);
        dynamicLoadingPage = new DynamicLoadingRepository(driver);
        fileDownloadPage = new FileDownloadRepository(driver);
        fileUploadPage = new FileUploadRepository(driver);
        floatingMenuPage = new FloatingMenuRepository(driver);
        iframePage = new iFrameRepository(driver);
        mouseHoverPage = new MouseHoverRepository(driver);
        javaScriptAlertsPage = new JavaScriptAlertsRepository(driver);
        javaScriptErrorPage = new JavaScriptErrorRepository(driver);
        openNewTabPage = new OpenNewTabRepository(driver);
        notificationMessagePage = new NotificationMessageRepository(driver);
    }

}
