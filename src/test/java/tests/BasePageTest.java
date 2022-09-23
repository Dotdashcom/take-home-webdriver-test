package tests;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import pages.LandingPage;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

public class BasePageTest {
    protected ChromeOptions chrmOptions;
    protected WebDriver driver;
    protected LandingPage landingPage;

    @BeforeTest
    public void readConfigs() {
        ConfigReader.loadApplicationProperties();
    }

    @BeforeMethod
    public void browserSetUp(){
        initializeBrowser();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();

        chrmOptions = new ChromeOptions();
        chrmOptions.addArguments("start-maximized");

        HashMap<String, Object> chrmPrefs = new HashMap<>();
        String downloadPath = Paths.get("upload-download").toAbsolutePath().toString();
        chrmPrefs.put("download.default_directory", downloadPath);

        chrmOptions.setExperimentalOption("prefs", chrmPrefs);

        driver = new ChromeDriver(chrmOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getApplicationProperty("landingURL"));
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    public void goToPage(String pageName){
        String landingURL = ConfigReader.getApplicationProperty("landingURL");
        String fullPageURL = landingURL + pageName;

        driver.get(fullPageURL);
    }
}

