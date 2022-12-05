package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtilities;
import utilities.WebDriverFactory;

import java.util.List;

public class BasePage extends BrowserUtilities {

    public WebDriver driver = WebDriverFactory.getDriver();
    public JavascriptExecutor js = (JavascriptExecutor) driver;
    public Actions action = new Actions(driver);
    public WebDriverWait wait = new WebDriverWait(driver, time);

    public String dragAndDrop = "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
            + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
            + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
            + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
            + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
            + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
            + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
            + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
            + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
            + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
            + "var dropEvent = createEvent('drop');\n"
            + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
            + "var dragEndEvent = createEvent('dragend');\n"
            + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
            + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
            + "simulateHTML5DragAndDrop(source,destination);";

    @FindBy(xpath = "//*[@type='checkbox']")
    public List<WebElement> checkboxes;

    @FindBy(id = "hot-spot")
    public WebElement contextMenuBox;

    @FindBy(css = "[id*='column-a']")
    public WebElement columnA;

    @FindBy(css = "[id*='column-b']")
    public WebElement columnB;

    @FindBy(id = "dropdown")
    public WebElement dropdownList;

    @FindBy(xpath = "(//*[@id='content'])[2]")
    public WebElement dynamicContentObject;

    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    public WebElement removeBtn;

    @FindBy(css = "[id='checkbox-example']")
    public WebElement checkBoxForm;

    @FindBy(css = "[id='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//*[text()='Add']")
    public WebElement addBtn;

    @FindBy(xpath = "//*[text()='Enable']")
    public WebElement enableBtn;

    @FindBy(css = "[id='input-example'] input")
    public WebElement inputBox;

    @FindBy(xpath = "//*[text()='Disable']")
    public WebElement disableBtn;

    @FindBy(xpath = "//*[text()='Start']")
    public WebElement startBtn;

    @FindBy(id = "finish")
    public WebElement header;

    @FindBy(linkText = "some-file.txt")
    public WebElement file;

    @FindBy(id = "file-upload")
    public WebElement chooseFile;

    @FindBy(id = "file-submit")
    public WebElement uploadBtn;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFiles;

    @FindBy(id = "menu")
    public WebElement floatingMenu;

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrame;

    @FindBy(css = "[class*='tox-button']")
    public WebElement notificationCloseBtn;

    @FindBy(id = "tinymce")
    public WebElement contentBody;

    @FindBy(className = "figure")
    public List<WebElement> images;

    @FindBy(css = "[onclick='jsAlert()']")
    public WebElement jsAlertBtn;

    @FindBy(css = "[onclick='jsConfirm()']")
    public WebElement jsConfirmBtn;

    @FindBy(css = "[onclick='jsPrompt()']")
    public WebElement jsPromptBtn;

    @FindBy(id = "result")
    public WebElement alertResult;

    @FindBy(css = "[onload='loadError()']")
    public WebElement jsError;

    @FindBy(linkText = "Click Here")
    public WebElement newWindowLink;

    @FindBy(className = "example")
    public WebElement newWindow;

    @FindBy(linkText = "Click here")
    public WebElement notificationLink;

    @FindBy(id = "flash")
    public WebElement notificationMsg;

    public BasePage(){
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(time);
    }
}
