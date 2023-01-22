package ui_automation.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;
import java.util.Map;

public class Driver {
  // beacuse we dont need other driver I didnt use Switch case
    private static WebDriver driver;

    public Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("download.default_directory", System.getProperty("user.dir")+
                    "/src/test/resources/TestData/Download");

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        }
        return driver;
    }


    public static void closeDriver() {
        if(driver != null){
            driver.quit();
        }


    }
}
