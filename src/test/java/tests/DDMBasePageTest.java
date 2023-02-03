package tests;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import pages.DDMLandingPage;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class DDMBasePageTest  {
    protected WebDriver driver;
    protected DDMLandingPage landingPage;
    protected String validUserName;
    protected String validPassword;

    @BeforeTest
    public void readConfigs()  {
        ConfigReader.loadProperties();
        validUserName = ConfigReader.getProperty("username");
        validPassword = ConfigReader.getProperty("password");
    }

    @BeforeMethod
    public void browserSetUp()  {
        initializeBrowser();
    }

    @AfterMethod
    public void closeDriver()  {
        driver.quit();
    }

    public void initializeBrowser()  {
        WebDriverManager.chromedriver().setup();

        HashMap<String, Object> chrmPrefs = new HashMap<>();
        String downloadPath = Paths.get("test-files").toAbsolutePath().toString();
        chrmPrefs.put("download.default_directory", downloadPath);

        ChromeOptions chrmOptions = new ChromeOptions();
        chrmOptions.addArguments("start-maximized");

        chrmOptions.setExperimentalOption("prefs", chrmPrefs);

        driver = new ChromeDriver(chrmOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getProperty("testPageURL"));
        landingPage = PageFactory.initElements(driver, DDMLandingPage.class);
    }
}