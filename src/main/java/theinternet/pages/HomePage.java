package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(.,'Form Authentication')]")
    public WebElement loginPageLink;
    @FindBy(xpath = "//a[contains(.,'Checkboxes')]")
    public WebElement checkboxPageLink;
    @FindBy(xpath = "//a[contains(.,'Context Menu')]")
    public WebElement contextMenuPageLink;
    @FindBy(xpath = "//a[contains(.,'Drag and Drop')]")
    public WebElement dragAndDropPageLink;
    @FindBy(xpath = "//a[contains(.,'Dropdown')]")
    public WebElement dropDownPageLink;
    @FindBy(xpath = "//a[contains(.,'Dynamic Content')]")
    public WebElement dynamicContextPageLink;
    @FindBy(xpath = "//a[contains(.,'Dynamic Controls')]")
    public WebElement dynamicControlsPageLink;
    @FindBy(xpath = "//a[contains(.,'File Download')]")
    public WebElement fileDownloadPageLink;
    @FindBy(xpath = "//a[contains(.,'Dynamic Loading')]")
    public WebElement dynamicLoadingPageLink;
    @FindBy(xpath = "//a[contains(.,'File Upload')]")
    public WebElement fileUploadPageLink;
    @FindBy(xpath = "//a[contains(.,'Floating Menu')]")
    public WebElement floatingMenuPageLink;
    @FindBy(xpath = "//a[contains(.,'Frames')]")
    public WebElement framesPageLink;
    @FindBy(xpath = "//a[contains(.,'iFrame')]")
    public WebElement iframePageLink;
    @FindBy(xpath = "//a[contains(.,'Hovers')]")
    public WebElement mouseHoverPageLink;
    @FindBy(xpath = "//a[contains(.,'JavaScript Alerts')]")
    public WebElement javaScriptAlertsPageLink;
    @FindBy(xpath = "//a[contains(.,'JavaScript onload event error')]")
    public WebElement javaScriptErrorPageLink;
    @FindBy(xpath = "//a[contains(.,'Multiple Windows')]")
    public WebElement newWindowsPageLink;
    @FindBy(xpath = "//a[contains(.,'Notification Messages')]")
    public WebElement notificationMessagesPage;

    public LoginPage navigateToLoginPage(){
        loginPageLink.click();
        return new LoginPage();
    }
    public CheckboxPage navigateToCheckBoxPage(){
        checkboxPageLink.click();
        return new CheckboxPage();
    }
    public ContextMenuPage navigateToContextMenuPage(){
        contextMenuPageLink.click();
        return new ContextMenuPage();
    }

    public DragAndDropPage navigateToDragAndDropPage() {
        dragAndDropPageLink.click();
        return new DragAndDropPage();
    }

    public DropdownPage navigateToDropdownPage() {
        dropDownPageLink.click();
        return new DropdownPage();
    }

    public DynamicContentPage navigateToDynamicContextPage() {
        dynamicContextPageLink.click();
        return new DynamicContentPage();
    }

    public DynamicControlsPage navigateToDynamicControlsPage() {
        dynamicControlsPageLink.click();
        return new DynamicControlsPage();
    }

    public FileDownloadPage navigateToFileDownloadPage() {
        fileDownloadPageLink.click();
        return new FileDownloadPage();
    }

    public DynamicLoadingPage navigateToDynamicLoadingPage() {
        dynamicLoadingPageLink.click();
        return new DynamicLoadingPage();
    }
    public FileUploadPage navigateToFileUploadPage() {
        fileUploadPageLink.click();
        return new FileUploadPage();
    }

    public FloatingMenuPage navigateToFloatingMenuPage() {
        floatingMenuPageLink.click();
        return new FloatingMenuPage();
    }

    public IframePage navigateToIframePage() throws InterruptedException {
        framesPageLink.click();
        Thread.sleep(2000);
        iframePageLink.click();
        return new IframePage();
    }

    public IframePage navigateToMouseHoverPage() {
        mouseHoverPageLink.click();
        return new IframePage();
    }
    public JavaScriptAlertPage navigateToJavaScriptAlertsPage() {
        javaScriptAlertsPageLink.click();
        return new JavaScriptAlertPage();
    }

    public JavaScriptErrorPage navigateToJavaScriptErrorPage() {
        javaScriptErrorPageLink.click();
        return new JavaScriptErrorPage();
    }

    public NewWindowsPage navigateToNewWindowsPage() {
        newWindowsPageLink.click();
        return new NewWindowsPage();
    }
    public NewWindowsPage navigateToNotificationMessagesPage() {
        notificationMessagesPage.click();
        return new NewWindowsPage();
    }
}
