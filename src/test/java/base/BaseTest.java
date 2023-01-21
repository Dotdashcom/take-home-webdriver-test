package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.Screenshot;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected ExtentManager extentManager;
    private final String filePath = "src/test/java/config/configuration.properties";

    @BeforeSuite
    public void startReporter(){
        extentManager = new ExtentManager();
        extentManager.createReport();
    }

    @AfterSuite
    public void endReporter(){
        extentManager.closeReport();
    }

    @BeforeMethod
    public void setUp(Method method){
        initializeDriver(ConfigReader.readProperty(filePath, "browser"));
        driver.get(ConfigReader.readProperty(filePath, "url"));
        extentManager.createTestReport(driver, method);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
       Screenshot.takeScreenshot(driver);
        extentManager.closeTestReport(result);
        extentManager.logScreenshot();
        driver.quit();
    }

    public void initializeDriver(String browser){
        driver = null;
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Wrong browser name was entered");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }


}
