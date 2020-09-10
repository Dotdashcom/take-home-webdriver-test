package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainClass {

    public static WebDriver driver;

    /**
     * Method for initializing WebDriver instance, opening the browser
     * and navigating the URL adn initializing all pages
     */
    public static void setUp() {

        String osName = System.getProperty("os.name");

        if (osName.contains("Mac OS X")) {
            ConfigsReader.read(Constants.CONFIG_FILEPATH_FOR_MAC);
        } else {
            ConfigsReader.read(Constants.CONFIG_FILEPATH);
        }

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);

        driver.get(ConfigsReader.getProperty("baseURL"));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

        PageInit.initialize();
    }

    /**
     * Method fro closing the browsers's windows and session
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
