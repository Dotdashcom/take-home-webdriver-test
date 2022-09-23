package core;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LandingPage;
import utils.ConfigReader;


public class BasePageTest {
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    protected FirefoxOptions ffOptions;
    protected EdgeOptions edgeOptions;
    protected String downloadFilePath;
    protected LandingPage landingPage;

    @BeforeSuite
    public void setUpTestSuite(){
        ConfigReader.initializeProperties();
    }

    @BeforeClass
    public void setUpDriver(){
        driverSetUp();
    }

    @AfterClass
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Close Driver: Interrupted Exception Found!!");
        }
        driver.quit();
    }

    public void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Logger.getAnonymousLogger().info("Sleep interrupted.");
        }
    }

    private void driverSetUp(){
        String browser = System.getProperty("browser");
        String headless = System.getProperty("headless");
        String maximize = System.getProperty("maximize");
        downloadFilePath = Paths.get("downloads").toAbsolutePath().toString();

        if(browser.equalsIgnoreCase("CHROME")){
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilePath);
            chromeOptions.setExperimentalOption("prefs", chromePrefs);

            if(headless.equalsIgnoreCase("TRUE")) {
                chromeOptions.addArguments("--headless");
            }
            if(maximize.equalsIgnoreCase("TRUE")) {
                chromeOptions.addArguments("start-maximized");
            }
            driver = new ChromeDriver(chromeOptions);

        } else if(browser.equalsIgnoreCase("FIREFOX")){
            WebDriverManager.firefoxdriver().setup();
            ffOptions = new FirefoxOptions();

            if(headless.equalsIgnoreCase("TRUE")) {
                ffOptions.addArguments("--headless");
            }
            if(maximize.equalsIgnoreCase("TRUE")) {
                driver = new FirefoxDriver(ffOptions);
                driver.manage().window().maximize();
            }
            driver = new FirefoxDriver(ffOptions);

        } else if(browser.equalsIgnoreCase("EDGE")){
            WebDriverManager.edgedriver().setup();
            edgeOptions = new EdgeOptions();

            if(headless.equalsIgnoreCase("TRUE")) {
                edgeOptions.addArguments("--headless");
            }
            if(maximize.equalsIgnoreCase("TRUE")) {
                edgeOptions.addArguments("start-maximized");
            }
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigReader.getAutProperty("baseURL"));
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }
}
