package LocalHost.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class Driver {
    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    private Driver() {

    }
    public synchronized static void intiDriver(String... arg) {
        String browser = ConfigsReader.get("browser");
        if (arg != null && arg.length > 0 && arg[0] != null) {
            browser = arg[0];
        }
        driver.set(genDriver(browser));
    }
    public static WebDriver genDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().setHeadless(true));
            default:
                throw new RuntimeException("Illegal browser type!");
        }
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void closeDriver() {
      driver.get().quit();
    }

}
