package utilities;

import enums.Paths;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {  // if driver/browser was never opened
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", Paths.DOWNLOAD_FOLDER.getPath());
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // this line will kill the session. value will noy be null
            driver = null;
        }
    }
}