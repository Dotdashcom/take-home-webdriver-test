package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestPage extends BasePage {
    protected WebDriver driver;

    public TestPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement userID;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@class='radius']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@class='icon-2x icon-signout']")
    public WebElement logoutBtn;

    @FindBy(css = ".subheader")
    public WebElement welcomeSign;

    @FindBy(xpath = "//*[@id='flash']")
    public WebElement loggedMsg;

    @FindBy(xpath = "//*[@class='flash error']")
    public WebElement logErrorMsg;

    @FindBy(xpath = "//input[1]")
    public WebElement checkBox1;

    @FindBy(xpath = "//input[2]")
    public WebElement checkBox2;

    @FindBy(css = ("#hot-spot"))
    public WebElement boxSpot;

    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement dropBoxA;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement dropBoxB;

    @FindBy(xpath = "//*[@id='dropdown']")
    public WebElement dropDown;

    @FindBy(xpath = "//a[normalize-space()='click here']")
    public WebElement clickDynamicPage;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]")
    public WebElement dynamicText;
    //Dynamic Controls 1
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement dynCheckBox;

    //Dynamic Controls 2
    @FindBy(xpath = "//button[normalize-space()='Remove']")
    public WebElement dynamicControlBtn;
    //Dynamic Controls 3
    @FindBy(xpath = "//p[@id='message']")
    public WebElement messageText;

    //Dynamic Loading
    @FindBy(xpath = "//button[normalize-space()='Start']")
    public WebElement startBtn;
    //Dynamic Loading
    @FindBy(xpath = "//h4[normalize-space()='Hello World!']")
    public WebElement helloWorldMsg;
    //File Download
    @FindBy(css = "a[href='download/some-file.txt']")
    public WebElement downloadFile;

    @FindBy(xpath = "//input[@name='file']")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement uploadFile;

    @FindBy(xpath = "//div[@id='menu']//ul/li")
    public List<WebElement> floatingMenu;

    //iFrame
    @FindBy(xpath = "//div[@aria-label='Close']//*[name()='svg']")
    public WebElement closeAlertBtn;

    // iFrameBox
    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iFrameBox;
    //_mce_caret
    @FindBy(xpath = "//body//p")
    public WebElement iFrameBox2;

    //Hover
    @FindBy(xpath = "//div[@class='example']//div[1]//img[1]")
    public WebElement hover;
    @FindBy(xpath = "//a[@href='/users/1']")
    public WebElement user1Btn;
    //AlertJS
    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    public WebElement jsAlert1;

    @FindBy(xpath = " //*[@id='result']")
    public WebElement alertResult;

    @FindBy(xpath = "//*[@id='main-message']")
    public WebElement newTabMessage;









}
