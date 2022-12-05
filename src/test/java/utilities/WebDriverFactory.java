package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class WebDriverFactory {

    //same for everyone
    private static WebDriver driver;
    protected static String downloadPath = System.getProperty("user.dir")+"\\downloads";

    //so no one can create object of Driver class
    //everyone should call static getter method instead

    private WebDriverFactory() {
    }

    public static synchronized WebDriver getDriver() {
//        String downloadPath = System.getProperty("user.dir")+"\\downloads";
        //if webdriver object doesn't exist
        //create it
        if (driver == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getValue("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    HashMap<String, Object> chromePref = new HashMap<>();
                    chromePref.put("download.default_directory", downloadPath);
                    options.setExperimentalOption("prefs", chromePref);
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
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
