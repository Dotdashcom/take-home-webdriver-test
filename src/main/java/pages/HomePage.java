package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Form Authentication")
    private WebElement fromAuthentication;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkBoxes;

    @FindBy(linkText = "Context Menu")
    private WebElement contextMenu;

    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDrop;

    @FindBy(linkText = "Dropdown")
    private WebElement dropDown;

    @FindBy(linkText = "Dynamic Content")
    private WebElement dynamicContent;

    @FindBy(linkText = "Dynamic Controls")
    private WebElement dynamicControl;

    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoading;

    @FindBy(linkText = "File Download")
    private WebElement fileDownLoad;

    @FindBy(linkText = "File Upload")
    private WebElement fileUpload;

    @FindBy(linkText = "Floating Menu")
    private WebElement floatMenu;

    @FindBy(linkText = "Frames")
    private WebElement frame;

    @FindBy(linkText= "Hovers")
    private WebElement hover;

    @FindBy(linkText = "JavaScript Alerts")
    private WebElement javaScriptAlert;

    @FindBy(linkText = "JavaScript onload event error")
    private WebElement javaScriptError;

    @FindBy(linkText = "Multiple Windows")
    private WebElement openNewTab;

    @FindBy(linkText = "Notification Messages")
    private WebElement notificationMessage;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickAuthenticationLink() {
        fromAuthentication.click();
        return new LoginPage(driver);
    }

    public CheckBoxesPage clickCheckBox() {
        checkBoxes.click();
        return new CheckBoxesPage(driver);

    }

    public ContextMenuPage clickContextMenu() {
        contextMenu.click();
        return new ContextMenuPage(driver);
    }

    public DragAndDropPage clickDragAndDrop() {
        dragAndDrop.click();
        return new DragAndDropPage(driver);
    }

    public DropDownPage clickDropDown() {
        dropDown.click();
        return new DropDownPage(driver);
    }

    public DynamicContentPage clickDynamicContent() {
        dynamicContent.click();
        return new DynamicContentPage(driver);
    }

    public DynamicControlsPage clickDynamicControl() {
        dynamicControl.click();
        return new DynamicControlsPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        dynamicLoading.click();
        return new DynamicLoadingPage(driver);
    }

    public FileDownloadPage clickFileDown() {
        fileDownLoad.click();
        return new FileDownloadPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        fileUpload.click();
        return new FileUploadPage(driver);
    }

    public FloatingMenuPage clickFloatMenu() {
        floatMenu.click();
        return new FloatingMenuPage(driver);
    }

    public IFramePage clickFrame() {
        frame.click();
        return new IFramePage(driver);
    }

    public MouseHoverPage clickHover() {
        hover.click();
        return new MouseHoverPage(driver);
    }

    public JavaScriptAlertsPage clickJavascriptAlert() {
        javaScriptAlert.click();
        return new JavaScriptAlertsPage(driver);
    }

    public JavaScriptErrorPage clickJavaScriptError() {
        javaScriptError.click();
        return new JavaScriptErrorPage(driver);
    }

    public OpenNewTabPage clickOpenNewTab() {
        openNewTab.click();
        return new OpenNewTabPage(driver);
    }

    public NotificationMessagePage clickNotification() {
        notificationMessage.click();
        return new NotificationMessagePage(driver);
    }


}
