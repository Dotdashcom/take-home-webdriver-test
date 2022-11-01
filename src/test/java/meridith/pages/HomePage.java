package meridith.pages;

import meridith.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//li[.='Checkboxes']")
    public WebElement checkBoxesLinkk;

    @FindBy(xpath="//*[@id='checkboxes']/input[1]")
    public WebElement checkBox1;

    @FindBy(xpath="//*[@id='checkboxes']/input[2]")
    public WebElement checkBox2;

    @FindBy(id="hot-spot")
    public WebElement contextArea;

    @FindBy(xpath="//*[@id='column-a']")
    public WebElement areaA;

    @FindBy(xpath="//*[@id='column-b']")
    public WebElement areaB;

    @FindBy(id="dropdown")
    public WebElement dropdown;

    @FindBy(xpath="//option[@selected]")
    public WebElement dropdownSelected;

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]")
    public WebElement content;

    @FindBy(xpath="//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(id="checkbox")
    public WebElement checkbox;
    @FindBy(xpath="//p[@id='message']")
    public WebElement message;

    @FindBy(xpath="//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath="//button[.='Disable']")
    public WebElement disableButton;

    @FindBy(xpath="//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath="//input[@type='text']")
    public WebElement textInput;

    @FindBy(xpath="//div[@id='start']//button")
    public WebElement startButton;

    @FindBy(id="finish")
    public WebElement finishText;
    @FindBy(xpath="//*[@id=\"content\"]/div/a")
    public WebElement fileDownloadLink;

    @FindBy(xpath="//*[@id='file-upload']")
    public WebElement fileUploadPath;

    @FindBy(id="file-submit")
    public WebElement fileSubmitButton;

    @FindBy(xpath="//*[@id='content']/div/h3")
    public WebElement fileUploaded;

    @FindBy(xpath="//*[@id=\"menu\"]/ul/li[1]/a")
    public WebElement floatingMenuItem;

    @FindBy(id="tinymce")
    public WebElement iframeWritingArea;

    @FindBy(xpath="//*[@id='content']/div/div[1]/img")
    public WebElement image1;
    @FindBy(xpath="//*[@id='content']/div/div[2]/img")
    public WebElement image2;
    @FindBy(xpath="//*[@id='content']/div/div[3]/img")
    public WebElement image3;

    @FindBy(xpath="//h5")
    public List<WebElement> addInfo;

    @FindBy(xpath="//p")
    public WebElement error;

    @FindBy(xpath="//*[@id='content']/div/a")
    public WebElement clickHere;

    @FindBy(xpath="//h3[.='New Window']")
    public WebElement newWindow;

    @FindBy(linkText="Click here")
    public WebElement actionClickHere;

    @FindBy(xpath="//*[@id='flash']")
    public WebElement notification;

    @FindBy(partialLinkText="Checkboxes")
    public WebElement CheckboxesLink;

    @FindBy(linkText="Context Menu")
    public WebElement ContextMenuLink;

    @FindBy(linkText="Drag and Drop")
    public WebElement DragandDropLink;

    @FindBy(linkText="Dropdown")
    public WebElement DropdownLink;

    @FindBy(linkText="Dynamic Content")
    public WebElement DynamicContentLink;


    @FindBy(linkText="Dynamic Controls")
    public WebElement DynamicControlsLink;

    @FindBy(linkText="Dynamic Loading")
    public WebElement DynamicLoadingLink;

    @FindBy(linkText="Example 2: Element rendered after the fact")
    public WebElement DynamicLoadingLink2;

    @FindBy(linkText="File Download")
    public WebElement FileDownloadLink;

    @FindBy(linkText="File Upload")
    public WebElement FileUploadLink;

    @FindBy(linkText="Floating Menu")
    public WebElement FloatingMenuLink;

    @FindBy(linkText="Frames")
    public WebElement FramesLink;

    @FindBy(linkText="iFrame")
    public WebElement iFrameLink;

    @FindBy(linkText="Hovers")
    public WebElement HoversLink;

    @FindBy(linkText="JavaScript onload event error")
    public WebElement JSErrorLink;

    @FindBy(linkText="Multiple Windows")
    public WebElement MultipleWindowsLink;

    @FindBy(linkText="Notification Messages")
    public WebElement NotificationMessagesLink;
}
