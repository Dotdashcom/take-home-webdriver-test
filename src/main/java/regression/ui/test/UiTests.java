package regression.ui.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;

public class UiTests {
    public static WebDriver driver;
    public static String baseUrl;
    public static String downloadFilePath;
    public static ClassLoader classloader;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/webDriver/chromedriver-85");
        UiTests.downloadFilePath = Paths.get("downloads").toAbsolutePath().toString();
    }

    @BeforeEach
    void setUp() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        baseUrl = "localhost:7080";

    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }
}
