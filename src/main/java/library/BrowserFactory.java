package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class BrowserFactory
{
    public static final String WORKING_DIR = System.getProperty("user.dir");
    public static final String DRIVER_PATH = WORKING_DIR + "/theInternet/src/resources/drivers/chromedriver.exe";

    public static final String   downloadFilepath = WORKING_DIR ;
    public static WebDriver driver;

   public static String getBaseURL() throws IOException {
       return new PropertiesFileReader().readDataFromPropertiesFiles("baseURL");
   }

    public static WebDriver launchDriver() throws IOException {
        String browserName = new PropertiesFileReader().readDataFromPropertiesFiles("browser");
        if ("CHROME".equals(browserName)) {
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            System.setProperty("driver.chromedriver", DRIVER_PATH);
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }

}
