package tests;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

import pages.LandingPage;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BasePageTest {

    protected ChromeOptions chrmOptions;

    protected WebDriver driver;

    protected LandingPage landingPage;

    protected String baseURL;

    protected String correctUserName;

    protected String correctPassword;

    protected String incorrectUserName;

    protected String incorrectPassword;

    @BeforeClass
    public void readConfigs() {
        ConfigReader.loadApplicationProperties();
        baseURL = ConfigReader.getApplicationProperty("baseURL");
        correctUserName = ConfigReader.getApplicationProperty("username");
        correctPassword = ConfigReader.getApplicationProperty("password");
        incorrectUserName = ConfigReader.getApplicationProperty("wrongUsername");
        incorrectPassword = ConfigReader.getApplicationProperty("wrongPassword");
    }

    @BeforeMethod
    public void browserSetUp() {
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
        chrmOptions.addArguments("--remote-allow-origins=*");

        HashMap<String, Object> chrmPrefs = new HashMap<>();
        String downloadPath = Paths.get("test-files").toAbsolutePath().toString();
        chrmPrefs.put("download.default_directory", downloadPath);

        chrmOptions.setExperimentalOption("prefs", chrmPrefs);

        driver = new ChromeDriver(chrmOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    public void goToPage(String pageName) {
        driver.get(baseURL + pageName);
    }
}

