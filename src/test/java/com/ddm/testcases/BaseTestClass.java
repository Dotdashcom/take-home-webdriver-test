package com.ddm.testcases;

import com.ddm.pageobjects.LandingPage;
import com.ddm.utilties.RunOptionsUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import com.ddm.utilties.ConfigUtility;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTestClass {

    protected static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    protected static String targetBrowser;

    protected static String baseURL;
    protected static String username;
    protected static String password;
    protected static String invalidUsername;
    protected static String invalidPassword;

    protected LandingPage landingPage;

    @BeforeSuite
    public void readConfigsBaseTest() {
        // Grab mvn arguments and store in the run properties
        RunOptionsUtility.initRunOpitons();
        //Read test env properties
        ConfigUtility.initConfigUtility("src/test/configuration/config.properties");
        baseURL = ConfigUtility.getBaseURL();
        username = ConfigUtility.getUsername();
        password = ConfigUtility.getPassword();
        invalidUsername = ConfigUtility.getInvalidUsername();
        invalidPassword = ConfigUtility.getInvalidPassword();

        targetBrowser = RunOptionsUtility.getRunOption("targetBrowser");
    }

    @BeforeMethod
    public void driverSetupBeforeEachMethodBastTest() {
        WebDriver driver = null;
        if(RunOptionsUtility.getRunOption("targetPlatform") == null ||
                RunOptionsUtility.getRunOption("targetPlatform").equalsIgnoreCase("local")) {
            if (targetBrowser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (targetBrowser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (targetBrowser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }

        } else if(RunOptionsUtility.getRunOption("targetPlatform").equalsIgnoreCase("lambdatest")) {
            // Build lambdatest cloud url with username and APIKey
            // Use ChromeOptions to fill targetOS and targetBrowser details
            // Get RemoteWebDriver
        }
        driverPool.set(driver);
        driverPool.get().manage().window().maximize();
        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverPool.get().get(baseURL);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    @AfterMethod
    public void quitDriverAfterMethodBaseTest() {
        if(RunOptionsUtility.getRunOption("quitBrowser").equalsIgnoreCase("true")) {
            driverPool.get().quit();
        }
    }
}
