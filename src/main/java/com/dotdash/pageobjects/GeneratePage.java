package com.dotdash.pageobjects;


import com.dotdash.utils.drivers.TLDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.support.PageFactory;

public class GeneratePage {

    private GeneratePage() {
        throw new IllegalStateException("GeneratePage cannot be instantiated");
    }

    private static synchronized <T extends BasePage> T instantiateNewPage(Class<T> tClass) {
        return PageFactory.initElements(TLDriverFactory.getTLDriver(), tClass);
    }

    public static LoginPage loginPage() {
        return instantiateNewPage(LoginPage.class);
    }

    public static CheckboxPage checkboxPage() {
        return instantiateNewPage(CheckboxPage.class);
    }

    public static ContextMenuPage contextMenuPage() {
        return instantiateNewPage(ContextMenuPage.class);
    }

    public static DragAndDropPage dragAndDropPage() {
        return instantiateNewPage(DragAndDropPage.class);
    }

    public static DropdownPage dropdownPage() {
        return instantiateNewPage(DropdownPage.class);
    }

    public static DynamicContentPage dynamicContentPage() {
        return instantiateNewPage(DynamicContentPage.class);
    }

    public static DynamicControlPage dynamicControlPage() {
        return instantiateNewPage(DynamicControlPage.class);
    }

    public static DynamicLoadingPage dynamicLoadingPage() {
        return instantiateNewPage(DynamicLoadingPage.class);
    }

    public static FileDownloadPage fileDownloadPage() {
        return instantiateNewPage(FileDownloadPage.class);
    }

    public static FileUploadPage fileUploadPage() {
        return instantiateNewPage(FileUploadPage.class);
    }

    public static FloatingMenuPage floatingMenuPage() {
        return instantiateNewPage(FloatingMenuPage.class);
    }

    public static IframePage iframePage() {
        return instantiateNewPage(IframePage.class);
    }

    public static MouseHoverPage mouseHoverPage() {
        return instantiateNewPage(MouseHoverPage.class);
    }

    public static JavaScriptAlertsPage javaScriptAlertsPage() {
        return instantiateNewPage(JavaScriptAlertsPage.class);
    }

    public static OpenInNewTabPage openInNewTabPage() {
        return instantiateNewPage(OpenInNewTabPage.class);
    }

    public static JavaScriptErrorPage javaScriptErrorPage() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        TLDriverFactory.setTLDriver("chrome");
        return PageFactory.initElements(TLDriverFactory.getTLDriver(), JavaScriptErrorPage.class);
    }

}
