import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests
{
    private static final WebDriver driver = new ChromeDriver();

    private static final TheInternetPage loginPage = new TheInternetPage(driver);
    private static final CheckboxesPage Checkboxpage = new CheckboxesPage(driver);
    private static final ContextMenuPage contextmenupage = new ContextMenuPage(driver);
    private static final DragDropPage dragdroppage = new DragDropPage(driver);
    private static final DropDownPage dropDownPage = new DropDownPage(driver);
    private static final DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
    private static final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
    private static final DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
    private static final FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
    private static final FileUploadPage fileUploadPage = new FileUploadPage(driver);
    private static final FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
    private static final IFramePage iFramePage = new IFramePage(driver);
    private static final MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
    private static final JavaScriptAltersPage JSAlertPage = new JavaScriptAltersPage(driver);
    private static final JavaScriptErrorPage JSErrorPage = new JavaScriptErrorPage(driver);
    private static final NewTabPage newTabPage = new NewTabPage(driver);
    private static final NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);

    @BeforeSuite
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver",Utilities.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Successful login")
    public static void SuccessfulLogin()
    {
        driver.get(Utilities.BASE_URL+"/login");
        driver.manage().window().maximize();

        loginPage.ValidLogin();

        Assert.assertEquals(true, loginPage.secure_area.isDisplayed());
        System.out.println("Secure area Header is displayed – Login Successful");

    }

    @Test(testName = "UnSuccessful login")
    public static void UnsuccessfulLogin()
    {
        driver.get(Utilities.BASE_URL+"/login");

        loginPage.InvalidLogin();

        Assert.assertEquals(true, loginPage.Invalid_area.isDisplayed());
        System.out.println("Secure area Header is not displayed – Login UnSuccessful");

    }

    @Test(testName = "Check the checkboxes")
    public static void CheckBox()
    {
        driver.get(Utilities.BASE_URL+"/checkboxes");
        Checkboxpage.Checkbox();

        Assert.assertTrue(true, String.valueOf(Checkboxpage.checkbox.isSelected()));
        System.out.println("All the check boxes are checked");

    }

    @Test(testName = "UnCheck the checkboxes")
    public static void UnCheckBox()
    {
        driver.get(Utilities.BASE_URL+"/checkboxes");
        Checkboxpage.UnCheckBox();

        Assert.assertTrue(true, String.valueOf(!Checkboxpage.checkbox.isSelected()));
        System.out.println("All the check boxes are unchecked");

    }
    @Test(testName = "Verify Context Menu")
    public static void ContextMenu()
    {
        driver.get(Utilities.BASE_URL+"/context_menu");
        contextmenupage.RightClick();

        //switching to alert
        Alert alert = driver.switchTo().alert();
        String alterText = alert.getText();

        Assert.assertEquals(alterText,"You selected a context menu");
        alert.accept();
    }

    @Test(testName = "verify Drag and drop")
    public  static void DragDrop()
    {
        driver.get(Utilities.BASE_URL+"/drag_and_drop");
        dragdroppage.DragandDrop();
    }

    @Test(testName = "Verify drop down")
    public static void Dropdown()
    {
        driver.get(Utilities.BASE_URL+"/dropdown");
        dropDownPage.SelectDropDownValue();

    }

    @Test(testName = "Verify Dynamic Content")
    public static void DynamicContent()
    {
        driver.get(Utilities.BASE_URL+"/dynamic_content ");
        dynamicContentPage.dynamicContent();
    }
    @Test(testName = "Verify Dynamic Controls")
    public static void DynamicControls()
    {
        driver.get(Utilities.BASE_URL+"/dynamic_controls ");
        dynamicControlsPage.dynamicControls();
    }
    @Test(testName = "Verify Dynamic Loading")
    public static void DynamicLoading()
    {
        driver.get(Utilities.BASE_URL+"/dynamic_loading/2 ");
        dynamicLoadingPage.dynamicloading();
    }
    @Test(testName = "Verify File Download")
    public static void FileDownload()
    {
        driver.get(Utilities.BASE_URL+"/download ");
        fileDownloadPage.DownloadFile();

    }
    @Test(testName = "Verify File Upload")
    public static void FileUpload()
    {
        driver.get(Utilities.BASE_URL+"/upload ");
        fileUploadPage.UploadFile();

    }
    @Test(testName = "Verify Floating Menu")
    public static void FloatingMenu()
    {
        driver.get(Utilities.BASE_URL+"/floating_menu ");
        floatingMenuPage.floatingmenu();

    }
    @Test(testName = "Verify IFrame")
    public static void IFrame()
    {
        driver.get(Utilities.BASE_URL+"/iframe");
        iFramePage.iframeactions();

    }
    @Test(testName = "Verify Mouse hover")
    public static void MouseHover()
    {
        driver.get(Utilities.BASE_URL+"/hovers");
        mouseHoverPage.mousehovering();
    }
    @Test(testName = "Verify Java Script Alerts")
    public static void JavaScriptAlerts()
    {
        driver.get(Utilities.BASE_URL+"/javascript_alerts");
        JSAlertPage.JSAlters();
    }
    @Test(testName = "Verify Java Script Error")
    public static void JavaScriptError()
    {
        driver.get(Utilities.BASE_URL+"/javascript_error");
        JSErrorPage.JSError();
    }
    @Test(testName = "Verify New tab is opened")
    public static void NewTab()
    {
        driver.get(Utilities.BASE_URL+"/windows");
        newTabPage.openNewTab();
    }
    @Test(testName = "Verify Notification messages")
    public static void NotificationMessage()
    {
        driver.get(Utilities.BASE_URL+"/notification_message_rendered");
        notificationMessagePage.notificationMsg();
    }

    @AfterSuite
    public static void cleanUp()
    {
       // driver.close();
    }
}
