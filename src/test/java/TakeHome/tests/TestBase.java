package TakeHome.tests;

import TakeHome.utilities.ConfigurationReader;
import TakeHome.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    protected String url;
    Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;
    protected String urlEndpoint;

    @BeforeMethod(onlyForGroups = "Login")
    public void SetupLogin(){
        urlEndpoint = ConfigurationReader.get("Login");
    }

    @BeforeMethod(onlyForGroups = "Context")
    public void SetupContext(){
        urlEndpoint = ConfigurationReader.get("Context");
    }

    @BeforeMethod(onlyForGroups = "DragDrop")
    public void SetupDragDrop(){
        urlEndpoint = ConfigurationReader.get("DragDrop");
    }

    @BeforeMethod(onlyForGroups = "DropDown")
    public void SetupDropDown(){
        urlEndpoint=ConfigurationReader.get("DropDown");
    }

    @BeforeMethod(onlyForGroups = "Dynamic_Content")
    public void SetupDynamic(){
        urlEndpoint=ConfigurationReader.get("Dynamic");
    }

    @BeforeMethod(onlyForGroups = "Dynamic_Control")
    public void SetUpDynamic_Control(){
       urlEndpoint=ConfigurationReader.get("DynamicControls");
    }

    @BeforeMethod(onlyForGroups = "Dynamic2")
    public void SetUpDynamic2(){
        urlEndpoint=ConfigurationReader.get("Dynamic2");
    }

    @BeforeMethod(onlyForGroups = "Download")
    public void SetUpDownload(){
        urlEndpoint=ConfigurationReader.get("Download");
    }

    @BeforeMethod(onlyForGroups = "Upload")
    public void SetupUpload(){
       urlEndpoint=ConfigurationReader.get("Upload");
    }

    @BeforeMethod(onlyForGroups = "Floating")
    public void SetUpFloating(){
        urlEndpoint=ConfigurationReader.get("Floating");
    }

    @BeforeMethod(onlyForGroups = "Iframes")
    public void SetUpFrames(){
        urlEndpoint=ConfigurationReader.get("Iframes");
    }

    @BeforeMethod(onlyForGroups = "Hover")
    public void SetUpHover(){
        urlEndpoint=ConfigurationReader.get("Hover");
    }

    @BeforeMethod(onlyForGroups = "JSAlert")
    public void SetupJSAlert(){
        urlEndpoint=ConfigurationReader.get("JSAlert");
    }

    @BeforeMethod(onlyForGroups = "JSError")
    public void SetUpJSError() {
        urlEndpoint = ConfigurationReader.get("JSError");
    }

    @BeforeMethod(onlyForGroups = "Windows")
    public void SetUpwindows(){
        urlEndpoint=ConfigurationReader.get("Windows");
    }

    @BeforeMethod(onlyForGroups = "Message")
    public void SetUpMessage(){
        urlEndpoint=ConfigurationReader.get("Message");
    }




    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Regression tests");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }


    @Test(enabled = false)
    @BeforeMethod(alwaysRun = true)
        public void setupMethod() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);

        if (urlEndpoint == null) {
            url = ConfigurationReader.get("url");
        } else {
            url = ConfigurationReader.get("url").concat(urlEndpoint);
        }
        driver.get(url);
    }
    
    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException, IOException {
        // IF FAILED TAKE SCREENSHOT
         if(result.getStatus() == ITestResult.FAILURE){
             // record the name of the failed testcase
             extentLogger.fail(result.getName());
             // take screenshot and return location of the screenshot
             //String screenshot = BrowserUtils.getScreenshot(result.getName());
             //extentLogger.addScreenCaptureFromPath(screenshot);
             // capture the exception
             extentLogger.fail(result.getThrowable());
         } else if (result.getStatus() == ITestResult.SKIP) {
             // sometime tests are skipped, this is how we log skipped tests
             extentLogger.skip("Test Skipped: " + result.getName());
         }

        // CLOSE BROWSER
        Thread.sleep(1000);
        Driver.closeDriver();
    }


}
