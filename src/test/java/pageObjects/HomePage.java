package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends Page {
    private static final String PAGE_LINK = "//a[@href='/%s']";

    public HomePage(ChromeDriver driver) {
        super(driver);
    }

    public LoginPage gotoLoginPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "login")), BasePage.TIMEOUT).click();
        return new LoginPage(driver);
    }

    public CheckboxesPage gotoCheckboxesPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "checkboxes")), BasePage.TIMEOUT).click();
        return new CheckboxesPage(driver);
    }

    public ContextMenuPage gotoContextMenuPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "context_menu")), BasePage.TIMEOUT).click();
        return new ContextMenuPage(driver);
    }

    public DragAndDropPage gotoDragAndDropPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "drag_and_drop")), BasePage.TIMEOUT).click();
        return new DragAndDropPage(driver);
    }

    public DropdownPage gotoDropdownPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "dropdown")), BasePage.TIMEOUT).click();
        return new DropdownPage(driver);
    }

    public DynamicContentPage gotoDynamicContentPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "dynamic_content")), BasePage.TIMEOUT).click();
        return new DynamicContentPage(driver);
    }

    public DynamicControlsPage gotoDynamicControlsPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "dynamic_controls")), BasePage.TIMEOUT).click();
        return new DynamicControlsPage(driver);
    }

    public DynamicLoadingPage gotoDynamicLoadingPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "dynamic_loading")), BasePage.TIMEOUT).click();
        elementToBeClickable(By.partialLinkText("2"), BasePage.TIMEOUT).click();
        return new DynamicLoadingPage(driver);
    }

    public FileDownloadPage gotoFileDownloadPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "download")), BasePage.TIMEOUT).click();
        return new FileDownloadPage(driver);
    }

    public FileUploadPage gotoFileUploadPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "upload")), BasePage.TIMEOUT).click();
        return new FileUploadPage(driver);
    }

    public FloatingMenuPage gotoFloatingMenuPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "floating_menu")), BasePage.TIMEOUT).click();
        return new FloatingMenuPage(driver);
    }

    public IframePage gotoIframePage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "frames")), BasePage.TIMEOUT).click();
        elementToBeClickable(By.linkText("iFrame"), BasePage.TIMEOUT).click();
        return new IframePage(driver);
    }

    public MouseHoverPage gotoMouseHoverPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "hovers")), BasePage.TIMEOUT).click();
        return new MouseHoverPage(driver);
    }

    public JavaScriptAlertsPage gotoJavaScriptAlertsPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "javascript_alerts")), BasePage.TIMEOUT).click();
        return new JavaScriptAlertsPage(driver);
    }

    public JavaScriptErrorPage gotoJavaScriptErrorPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "javascript_error")), BasePage.TIMEOUT).click();
        return new JavaScriptErrorPage(driver);
    }

    public OpenNewTabPage gotoOpenNewTabPage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "windows")), BasePage.TIMEOUT).click();
        return new OpenNewTabPage(driver);
    }

    public NotificationMessagePage gotoNotificationMessagePage() {
        elementToBeClickable(By.xpath(String.format(PAGE_LINK, "notification_message")), BasePage.TIMEOUT).click();
        return new NotificationMessagePage(driver);
    }
}
