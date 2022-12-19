package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/login'][contains(.,'Form Authentication')]")
    public WebElement loginPageLink;
    @FindBy(xpath = "//a[@href='/checkboxes'][contains(.,'Checkboxes')]")
    public WebElement checkboxPageLink;
    @FindBy(xpath = "//a[@href='/context_menu'][contains(.,'Context Menu')]")
    public WebElement contextMenuPageLink;
    @FindBy(xpath = "//a[@href='/drag_and_drop'][contains(.,'Drag and Drop')]")
    public WebElement dragAndDropPageLink;
    @FindBy(xpath = "//a[@href='/dropdown'][contains(.,'Dropdown')]")
    public WebElement dropDownPageLink;
    @FindBy(xpath = "//a[@href='/dynamic_content'][contains(.,'Dynamic Content')]")
    public WebElement dynamicContextPageLink;
    @FindBy(xpath = "//a[@href='/dynamic_controls'][contains(.,'Dynamic Controls')]")
    public WebElement dynamicControlsPageLink;
    @FindBy(xpath = "//a[@href='/download'][contains(.,'File Download')]")
    public WebElement fileDownloadPageLink;
    @FindBy(xpath = "//a[@href='/dynamic_loading'][contains(.,'Dynamic Loading')]")
    public WebElement dynamicLoadingPageLink;
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
}
