package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class Driver {
    private final static Logger logger = Logger.getLogger(Driver.class);
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromiumdriver().setup();
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    LoggingPreferences loggingprefs = new LoggingPreferences();
                    loggingprefs.enable(LogType.BROWSER, Level.ALL);
                    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
                    driver = new ChromeDriver(capabilities);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    logger.error("Browser not implemented yet!");
                    throw new RuntimeException("Browser not implemented yet!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
