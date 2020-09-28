package LocalHost.Tests;

import LocalHost.Utilities.ConfigsReader;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class TestingBase {
    protected WebDriver driver;

    protected String url;
    protected Actions actions;
    protected WebDriverWait webDriverWait;
    protected String Dashboard;
    protected DesiredCapabilities capabilities;

    @BeforeMethod(onlyForGroups = "Login")
    public void SetupLogin(){
        Dashboard=ConfigsReader.get("Login");
    }

    @BeforeMethod(onlyForGroups = "Checkbox")
    public void SetupCheckbox(){
        Dashboard=ConfigsReader.get("Checkbox");
    }

    @BeforeMethod(onlyForGroups = "ContextMenu")
    public void SetupContext(){
        Dashboard=ConfigsReader.get("Context");
    }

    @BeforeMethod(onlyForGroups = "DragDrop")
    public void SetupDragDrop(){
        Dashboard=ConfigsReader.get("DragDrop");
    }

    @BeforeMethod(onlyForGroups = "DropDown")
    public void SetupDropDown(){
        Dashboard=ConfigsReader.get("DropDown");
    }

    @BeforeMethod(onlyForGroups = "Dynamic_Content")
    public void SetupDynamic(){
        Dashboard=ConfigsReader.get("Dynamic");
    }

    @BeforeMethod(onlyForGroups = "Dynamic_Control")
    public void SetUpDynamic_Control(){
        Dashboard=ConfigsReader.get("DynamicControls");
    }

    @BeforeMethod(onlyForGroups = "Dynamic2")
    public void SetUpDynamic2(){
        Dashboard=ConfigsReader.get("Dynamic2");
    }

    @BeforeMethod(onlyForGroups = "Download")
    public void SetUpDownload(){
        Dashboard=ConfigsReader.get("Download");
    }

    @BeforeMethod(onlyForGroups = "Upload")
    public void SetupUpload(){
        Dashboard=ConfigsReader.get("Upload");
    }

    @BeforeMethod(onlyForGroups = "Floating")
    public void SetUpFloating(){
        Dashboard=ConfigsReader.get("Floating");
    }

    @BeforeMethod(onlyForGroups = "Iframes")
    public void SetUpFrames(){
        Dashboard=ConfigsReader.get("Iframes");
    }

    @BeforeMethod(onlyForGroups = "Hover")
    public void SetUpHover(){
        Dashboard=ConfigsReader.get("Hover");
    }

    @BeforeMethod(onlyForGroups = "JSAlert")
    public void SetupJSAlert(){
        Dashboard=ConfigsReader.get("JSAlert");
    }

    @BeforeMethod(onlyForGroups = "JSError")
    public void SetUpJSError() {
        Dashboard = ConfigsReader.get("JSError");
    }

    @BeforeMethod(onlyForGroups = "Windows")
    public void SetUpwindows(){
        Dashboard=ConfigsReader.get("Windows");
    }

    @BeforeMethod(onlyForGroups = "Message")
    public void SetUpMessage(){
        Dashboard=ConfigsReader.get("Message");
    }



    @Test(enabled = false)
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setupMethod(@Optional String browser) {
            Driver.intiDriver(browser);
            driver = Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 10);
        if (Dashboard == null) {
            url = ConfigsReader.get("base_url");
        } else {
            url = ConfigsReader.get("base_url").concat(Dashboard);
        }
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        Driver.closeDriver();
    }

}
